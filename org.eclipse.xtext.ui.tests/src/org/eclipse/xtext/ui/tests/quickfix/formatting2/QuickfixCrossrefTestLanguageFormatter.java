/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.quickfix.formatting2;

import static org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.QuickfixCrossrefPackage.Literals.*;

import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.Element;
import org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.Main;
import org.eclipse.xtext.ui.tests.quickfix.services.QuickfixCrossrefTestLanguageGrammarAccess;
import org.eclipse.xtext.ui.tests.quickfix.services.QuickfixCrossrefTestLanguageGrammarAccess.ElementElements;

import com.google.inject.Inject;

public class QuickfixCrossrefTestLanguageFormatter extends AbstractJavaFormatter {

	@Inject
	private QuickfixCrossrefTestLanguageGrammarAccess grammarAccess;

	protected void format(Main main, IFormattableDocument doc) {
		for (Element element : main.getElements()) {
			doc.format(element);
		}
	}

	protected void format(Element element, IFormattableDocument doc) {
		ElementElements elementAccess = grammarAccess.getElementAccess();

		doc.prepend(regionFor(element).feature(ELEMENT__DOC), this::noSpace);
		doc.append(regionFor(element).feature(ELEMENT__DOC), this::oneSpace);
		doc.append(regionFor(element).feature(ELEMENT__NAME), this::oneSpace);
		doc.append(regionFor(element).keyword(elementAccess.getLeftCurlyBracketKeyword_2()), this::newLine);
		for (ISemanticRegion refKeyword : regionFor(element).keywords(elementAccess.getRefKeyword_4_0())) {
			doc.append(refKeyword, this::oneSpace);
		}
		for (ISemanticRegion elementReferenced : regionFor(element).features(ELEMENT__REFERENCED)) {
			doc.append(elementReferenced, this::newLine);
		}
		doc.interior(element, this::indent);
		doc.append(element, this::newLine);

		for (Element contained : element.getContained()) {
			doc.format(contained);
		}
	}

}
