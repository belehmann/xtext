/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.fileAware.formatting2;

import static org.eclipse.xtext.testlanguages.fileAware.fileAware.FileAwarePackage.Literals.*;

import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.Element;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.FileAwarePackage;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.Import;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration;
import org.eclipse.xtext.testlanguages.fileAware.services.FileAwareTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.fileAware.services.FileAwareTestLanguageGrammarAccess.ElementElements;
import org.eclipse.xtext.testlanguages.fileAware.services.FileAwareTestLanguageGrammarAccess.ImportElements;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class FileAwareTestLanguageFormatter extends AbstractJavaFormatter {
	
	@Inject
	private FileAwareTestLanguageGrammarAccess grammarAccess;

	protected void format(PackageDeclaration pkg, IFormattableDocument doc) {
		ImportElements importAccess = grammarAccess.getImportAccess();
		
		doc.append(regionFor(pkg).feature(FileAwarePackage.Literals.PACKAGE_DECLARATION__NAME), it -> it.setNewLines(2));
		Import last = Iterables.getLast(pkg.getImports(), null);
		for (Import imp : pkg.getImports()) {
			doc.append(regionFor(imp).keyword(importAccess.getImportKeyword_0()), this::oneSpace);
			doc.format(imp);
			doc.append(imp, it -> it.setNewLines(imp == last ? 2 : 1));
		}
		for (Element element : pkg.getContents()) {
			doc.format(element);
		}
	}

	protected void format(Element element, IFormattableDocument doc) {
		ElementElements elementAccess = grammarAccess.getElementAccess();
		
		doc.prepend(regionFor(element).keyword(elementAccess.getElementKeyword_0()), this::noSpace);
		doc.append(regionFor(element).keyword(elementAccess.getElementKeyword_0()), this::oneSpace);
		doc.append(regionFor(element).feature(ELEMENT__NAME), this::oneSpace);
		doc.append(regionFor(element).keyword(elementAccess.getLeftCurlyBracketKeyword_2()), this::newLine);
		for (ISemanticRegion refKeyword : regionFor(element).keywords(elementAccess.getRefKeyword_3_1_0())) {
			doc.append(refKeyword, this::oneSpace);
		}
		for (ISemanticRegion elementRef : regionFor(element).features(ELEMENT__REF)) {
			doc.append(elementRef, this::newLine);
		}
		doc.interior(element, this::indent);
		doc.append(element, this::newLine);
		
		for (Element ele : element.getContents()) {
			doc.format(ele);
		}
	}
	
}
