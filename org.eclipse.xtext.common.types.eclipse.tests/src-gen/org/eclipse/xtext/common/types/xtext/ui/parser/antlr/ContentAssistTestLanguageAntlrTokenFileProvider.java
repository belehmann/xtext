/*
 * generated by Xtext
 */
package org.eclipse.xtext.common.types.xtext.ui.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class ContentAssistTestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalContentAssistTestLanguage.tokens");
	}
}
