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
import org.junit.Ignore;
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

	@Ignore("until formatting issues are solved")
	@Test
	public void testSingleSelectedLineIsCorrectlyIndented() {
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

}
