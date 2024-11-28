/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.region;

import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.eclipse.xtext.testlanguages.fileAware.tests.FileAwareTestLanguageInjectorProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author blehmann - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(FileAwareTestLanguageInjectorProvider.class)
public class RegionFormattingTest {

	@Inject
	private FormatterTestHelper formatterTestHelper;

	/**
	 * In this test the parent of the selection (element B) is on the same
	 * indentation level (level 1) as it would be after formatting the entire
	 * document (hitting Ctrl+Shift+F without selection). Expectation is that
	 * the selected line (ref A) is formatted to level 2 which is also the same
	 * as it would be after formatting without selection.
	 */
	@Test
	public void singleSelectedLineIsFormattedToIndentationLevel2_withParentOnLevel1() {
		// @formatter:off
		String input =
				"package A\n" +
				"\n" +
				"element A {\n" +
				"\telement B {\n" +
				"\tref A\n" +
				"\t}\n" +
				"}\n";
		String expected =
				"package A\n" +
				"\n" +
				"element A {\n" +
				"\telement B {\n" +
				"\t\tref A\n" +
				"\t}\n" +
				"}\n";
		// @formatter:on
		String selection = "\tref A\n";
		ITextRegion selectedRegion = new TextRegion(input.indexOf(selection), selection.length());

		formatterTestHelper.assertFormatted(formatterTestRequest -> {
			formatterTestRequest.setToBeFormatted(input);
			formatterTestRequest.setExpectation(expected);
			FormatterRequest formatterRequest = new FormatterRequest();
			formatterRequest.addRegion(selectedRegion);
			formatterTestRequest.setRequest(formatterRequest);
		});
	}

	/**
	 * In this test the parent of the selection (element B) is NOT on the same
	 * indentation level as it would be after formatting the entire document
	 * (hitting Ctrl+Shift+F without selection). Expectation is that the
	 * selected line (ref A) is formatted <b>relative</b> to the current parent
	 * indentation level (level 0) and is indented to level 1.
	 */
	@Test
	public void singleSelectedLineIsFormattedToIndentationLevel1_withParentOnLevel0() {
		// @formatter:off
		String input =
				"package A\n" +
				"\n" +
				"element A {\n" +
				"element B {\n" +
				"ref A\n" +
				"}\n" +
				"}\n";
		String expected =
				"package A\n" +
				"\n" +
				"element A {\n" +
				"element B {\n" +
				"\tref A\n" +
				"}\n" +
				"}\n";
		// @formatter:on
		String selection = "ref A\n";
		ITextRegion selectedRegion = new TextRegion(input.indexOf(selection), selection.length());

		formatterTestHelper.assertFormatted(formatterTestRequest -> {
			formatterTestRequest.setToBeFormatted(input);
			formatterTestRequest.setExpectation(expected);
			FormatterRequest formatterRequest = new FormatterRequest();
			formatterRequest.addRegion(selectedRegion);
			formatterTestRequest.setRequest(formatterRequest);
		});
	}
}
