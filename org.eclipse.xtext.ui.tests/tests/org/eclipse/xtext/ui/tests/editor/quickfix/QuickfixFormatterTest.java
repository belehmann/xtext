/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.quickfix;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest;
import org.eclipse.xtext.ui.tests.quickfix.ui.tests.QuickfixCrossrefTestLanguageUiInjectorProvider;
import org.eclipse.xtext.ui.tests.quickfix.validation.QuickfixCrossrefTestLanguageValidator;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author blehmann - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(QuickfixCrossrefTestLanguageUiInjectorProvider.class)
public class QuickfixFormatterTest extends AbstractQuickfixTest {

	@Test
	public void testAddDocumentation() {
		// @formatter:off
		String input =
				"myElements {\n" +
				"\tparent {\n" +
				"\t\tneedDocumentation {\n" +
				"\t\t}\n" +
				"\t}\n" +
				"}\n";
		String expected =
				"myElements {\n" +
				"\tparent {\n" +
				"\t\t\"doc\" needDocumentation {\n" +
				"\t\t}\n" +
				"\t}\n" +
				"}\n";
		// @formatter:on
		testQuickfixesOn(input, QuickfixCrossrefTestLanguageValidator.NEED_DOCUMENTATION,
				new Quickfix("add documentation", "add documentation", expected));
	}

	@Ignore("until formatting issues are solved")
	@Test
	public void testAddSibling() {
		// @formatter:off
		String input =
				"myElements {\n" +
				"\tparent {\n" +
				"\t\tneedSibling {\n" +
				"\t\t}\n" +
				"\t}\n" +
				"}\n";
		String expected =
				"myElements {\n" +
				"\tparent {\n" +
				"\t\tneedSibling {\n" +
				"\t\t}\n" +
				"\t\tsibling {\n" +
				"\t\t}\n" +
				"\t}\n" +
				"}\n";
		// @formatter:on
		testQuickfixesOn(input, QuickfixCrossrefTestLanguageValidator.NEED_SIBLING,
				new Quickfix("add sibling", "add sibling", expected));
	}

}
