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
public abstract class AbstractParsedToken {

	private final CharSequence input;
	
	private final int offset;
	
	private final int length;
	
	/**
	 * @param input
	 * @param offset
	 * @param length
	 */
	public AbstractParsedToken(CharSequence input, int offset, int length) {
		super();
		this.input = input;
		this.length = length;
		this.offset = offset;
	}

	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitAbstractParsedToken(this);
	}

	public CharSequence getText() {
		return input.subSequence(getOffset(), getOffset() + length);
	}

	public CharSequence getInput() {
		return input;
	}

	public int getLength() {
		return length;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": '" + getText() + "'@" + getOffset();
	}

	public int getOffset() {
		return offset;
	}
	
}
