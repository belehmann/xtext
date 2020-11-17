/*******************************************************************************
 * Copyright (c) 2020 Karakun GmbH (http://www.karakun.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.css.swt.theme.IThemeEngine;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend.ide.highlighting.XtendThemeManager;
import org.osgi.framework.BundleContext;

/**
 * @author Karsten Thoms - Initial contribution and API
 */
public class XtendActivator extends org.eclipse.xtend.ide.internal.XtendActivator {
	private static XtendActivator INSTANCE;
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		IWorkbench workbench = PlatformUI.getWorkbench();
		IEventBroker eventBroker = workbench.getService(IEventBroker.class);
		if (eventBroker != null) {
			eventBroker.subscribe(IThemeEngine.Events.THEME_CHANGED, new XtendThemeManager());
		}
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		INSTANCE = null;
		super.stop(context);
	}
	
	public static XtendActivator getInstance() {
		return INSTANCE;
	}
}
