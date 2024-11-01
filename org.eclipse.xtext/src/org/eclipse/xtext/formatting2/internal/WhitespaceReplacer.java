/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.IAutowrapFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.debug.HiddenRegionFormattingToString;
import org.eclipse.xtext.formatting2.regionaccess.IAstRegion;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextReplacement;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class WhitespaceReplacer implements ITextReplacer {

	private final IHiddenRegionFormatting formatting;
	private final ITextSegment region;

	public WhitespaceReplacer(ITextSegment whitespace, IHiddenRegionFormatting formatting) {
		super();
		this.region = whitespace;
		this.formatting = formatting;
	}

	protected int computeNewIndentation(ITextReplacerContext context) {
		Integer indentationIncrease = formatting.getIndentationIncrease();
		Integer indentationDecrease = formatting.getIndentationDecrease();
		int indenation = context.getIndentation();
		if (indentationIncrease != null)
			indenation += indentationIncrease;
		if (indentationDecrease != null)
			indenation -= indentationDecrease;
		if (indenation >= 0)
			return indenation;
		return 0; // TODO: handle indentation underflow
	}

	protected int computeNewLineCount(ITextReplacerContext context) {
		Integer newLineDefault = formatting.getNewLineDefault();
		Integer newLineMin = formatting.getNewLineMin();
		Integer newLineMax = formatting.getNewLineMax();
		if (newLineMin != null || newLineDefault != null || newLineMax != null) {
			if (region instanceof IHiddenRegion && ((IHiddenRegion) region).isUndefined()) {
				if (newLineDefault != null)
					return newLineDefault;
				if (newLineMin != null)
					return newLineMin;
				if (newLineMax != null)
					return newLineMax;
			} else {
				int lineCount = region.getLineCount() - 1;
				if (newLineMin != null && newLineMin > lineCount)
					lineCount = newLineMin;
				if (newLineMax != null && newLineMax < lineCount)
					lineCount = newLineMax;
				return lineCount;
			}
		}
		return 0;
	}

	@Override
	public ITextReplacerContext createReplacements(ITextReplacerContext context) {
		if (formatting.getAutowrap() != null && formatting.getAutowrap() >= 0)
			context.setCanAutowrap(formatting.getAutowrap());
		String space = formatting.getSpace();
		int trailingNewLinesOfPreviousRegion = trailingNewLinesOfPreviousRegion();
		int computedNewLineCount = computeNewLineCount(context);
		int newLineCount = Math.max(computedNewLineCount - trailingNewLinesOfPreviousRegion, 0);
		if (newLineCount == 0 && context.isAutowrap()) {
			IAutowrapFormatter onAutowrap = formatting.getOnAutowrap();
			if (onAutowrap != null) {
				onAutowrap.format(region, formatting, context.getDocument());
			}
			newLineCount = 1;
		}
		int indentationCount = computeNewIndentation(context);

		List<IEObjectRegion> eObjRegions = getAllEObjectRegions(region.getTextRegionAccess().regionForRootEObject());
		Map<Integer, IEObjectRegion> offsetToEObjectRegion = getOffsetToEObjectRegion(eObjRegions);
		
		// IF (the end-offset of this region is the offset of any EObjectRegion) AND
		// (the EObjectRegion is NOT contained in any of the requested ranges) THEN
		// set the indentation level to the indentation level of the EObjectRegion.
		if (offsetToEObjectRegion.containsKey(region.getEndOffset())) {
			IEObjectRegion eObjRegion = offsetToEObjectRegion.get(region.getEndOffset());
			if (!isInRequestedRange(eObjRegion, context)) {
				String indentationString = eObjRegion.getLineRegions().get(0).getIndentation().getText();
				indentationCount = getIndentationLevel(indentationString, context);
			}
		}
		
		if (newLineCount == 0 && trailingNewLinesOfPreviousRegion == 0) {
			if (space != null) {
				ITextReplacement replacement = region.replaceWith(space);
				if (overlapsWithRequestedRange(replacement, context)) {
					replacement = getReplacementConfinedToRequestedRange(replacement, context);
					context.addReplacement(replacement);
				}
			}
		} else {
			boolean noIndentation = formatting.getNoIndentation() == Boolean.TRUE;
			String newLines = context.getNewLinesString(newLineCount);
			String indentation = noIndentation ? "" : context.getIndentationString(indentationCount);
			ITextReplacement replacement = region.replaceWith(newLines + indentation);
			if (overlapsWithRequestedRange(replacement, context)) {
				replacement = getReplacementConfinedToRequestedRange(replacement, context);
				context.addReplacement(replacement);
			}
		}
		return context.withIndentation(indentationCount);
	}
	
	private static Map<Integer, IEObjectRegion> getOffsetToEObjectRegion(Iterable<IEObjectRegion> eObjRegions) {
		Map<Integer, IEObjectRegion> offsetToEObjectRegion = new HashMap<>();
		for (IEObjectRegion eObjRegion : eObjRegions) {
			offsetToEObjectRegion.put(eObjRegion.getOffset(), eObjRegion);
		}
		return offsetToEObjectRegion;
	}
	
	private static List<IEObjectRegion> getAllEObjectRegions(IEObjectRegion rootEObjRegion) {
		List<IEObjectRegion> regions = new ArrayList<>();
		regions.add(rootEObjRegion);
		for (IAstRegion astRegion : rootEObjRegion.getAstRegions()) {
			if (astRegion instanceof IEObjectRegion) {
				regions.addAll(getAllEObjectRegions((IEObjectRegion) astRegion));
			}
		}
		return regions;
	}
	
	private static int getIndentationLevel(String indentationString, ITextReplacerContext context) {
		final String indentation = context.getFormatter().getPreference(FormatterPreferenceKeys.indentation);
		int indentationLevel = 0, offset = 0;
		while (indentationString.startsWith(indentation, offset)) {
			indentationLevel++;
			offset += indentation.length();
		}
		return indentationLevel;
	}
	
	private static boolean isInRequestedRange(ITextRegion region, ITextReplacerContext context) {
		Collection<ITextRegion> requestedRegions = context.getDocument().getRequest().getRegions();
		if (requestedRegions.isEmpty()) {
			return true;
		}
		for (ITextRegion requestedRegion : requestedRegions) {
			if (requestedRegion.contains(region)) {
				return true;
			}
		}
		return false;
	}

	private static boolean overlapsWithRequestedRange(ITextRegion region, ITextReplacerContext context) {
		Collection<ITextRegion> requestedRegions = context.getDocument().getRequest().getRegions();
		if (requestedRegions.isEmpty()) {
			return true;
		}
		for (ITextRegion requestedRegion : requestedRegions) {
			if (doOverlap(requestedRegion, region)) {
				return true;
			}
		}
		return false;
	}

	private static boolean doOverlap(ITextRegion region1, ITextRegion region2) {
		int region1Begin = region1.getOffset();
		int region1End = region1Begin + region1.getLength();
		int region2Begin = region2.getOffset();
		int region2End = region2Begin + region2.getLength();
		
		if (region1Begin - region2End <= 0 && region2Begin - region1End <= 0) {
			return true;
		}
		return false;
	}
	
	private static ITextRegion getOverlapWithRequestedRange(ITextReplacement replacement, ITextReplacerContext context) {
		Collection<ITextRegion> regions = context.getDocument().getRequest().getRegions();
		for (ITextRegion region : regions) {
			if (doOverlap(region, replacement)) {
				return overlapRegion(region, replacement);
			}
		}
		return replacement;
	}

	private static ITextReplacement getReplacementConfinedToRequestedRange(ITextReplacement replacement, ITextReplacerContext context) {
		ITextRegion overlapRegion = getOverlapWithRequestedRange(replacement, context);
		int overlapBegin = overlapRegion.getOffset();
		int overlapEnd = overlapBegin + overlapRegion.getLength();
		int replacementBegin = replacement.getOffset();
		int replacementEnd = replacement.getEndOffset();
		
		String replacementText = replacement.getReplacementText();
		if (overlapBegin > replacementBegin) {
			int stripLeading = min(overlapBegin - replacementBegin, replacementText.length());
			replacementText = replacementText.substring(stripLeading);
		}
		if (replacementEnd > overlapEnd) {
			int stripTrailing = min(replacementEnd - overlapEnd, replacementText.length());
			replacementText = replacementText.substring(0, replacementText.length() - stripTrailing);
		}
		replacement = new TextReplacement(replacement.getTextRegionAccess(), overlapRegion.getOffset(),
				overlapRegion.getLength(), replacementText);
		return replacement;
	}

	private static ITextRegion overlapRegion(ITextRegion region1, ITextRegion region2) {
		int region1Begin = region1.getOffset();
		int region1End = region1Begin + region1.getLength();
		int region2Begin = region2.getOffset();
		int region2End = region2Begin + region2.getLength();
		
		int overlapBegin = max(region1Begin, region2Begin);
		int overlapEnd = min(region1End, region2End);
		int overlapLength = overlapEnd - overlapBegin;
		
		return new TextRegion(overlapBegin, overlapLength);
	}

	public IHiddenRegionFormatting getFormatting() {
		return formatting;
	}

	@Override
	public ITextSegment getRegion() {
		return region;
	}

	@Override
	public String toString() {
		return new HiddenRegionFormattingToString().apply(formatting);
	}

	protected int trailingNewLinesOfPreviousRegion() {
		int offset = region.getOffset();
		if (offset < 1)
			return 0;
		String previous = region.getTextRegionAccess().textForOffset(offset - 1, 1);
		if ("\n".equals(previous))
			return 1;
		return 0;
	}
}
