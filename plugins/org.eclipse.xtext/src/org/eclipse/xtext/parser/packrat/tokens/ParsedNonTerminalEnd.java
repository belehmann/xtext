/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParsedNonTerminalEnd extends AbstractParsedToken {

	private final String feature;
	private final boolean isMany;
	private final boolean isDatatype;

	public ParsedNonTerminalEnd(CharSequence input, int offset, String feature, boolean isMany, boolean isDatatype) {
		super(input, offset, 0);
		this.feature = feature;
		this.isMany = isMany;
		this.isDatatype = isDatatype;
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitParsedNonTerminalEnd(this);
	}

	public String getFeature() {
		return feature;
	}

	public boolean isMany() {
		return isMany;
	}

	public boolean isDatatype() {
		return isDatatype;
	}
	
}
