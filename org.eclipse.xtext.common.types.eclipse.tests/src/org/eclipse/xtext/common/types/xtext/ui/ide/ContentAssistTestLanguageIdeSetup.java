/*
 * generated by Xtext unknown
 */
package org.eclipse.xtext.common.types.xtext.ui.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.common.types.xtext.ui.ContentAssistTestLanguageRuntimeModule;
import org.eclipse.xtext.common.types.xtext.ui.ContentAssistTestLanguageStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class ContentAssistTestLanguageIdeSetup extends ContentAssistTestLanguageStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new ContentAssistTestLanguageRuntimeModule(), new ContentAssistTestLanguageIdeModule()));
	}
	
}
