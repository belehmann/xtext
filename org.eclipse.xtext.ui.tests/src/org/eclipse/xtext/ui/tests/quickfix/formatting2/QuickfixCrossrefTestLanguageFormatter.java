/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.quickfix.formatting2;

import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.Element;
import org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.Main;

public class QuickfixCrossrefTestLanguageFormatter extends AbstractJavaFormatter {

	protected void format(Main main, IFormattableDocument doc) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (Element element : main.getElements()) {
			doc.format(element);
		}
	}

	protected void format(Element element, IFormattableDocument doc) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (Element _element : element.getContained()) {
			doc.format(_element);
		}
	}
	
}
