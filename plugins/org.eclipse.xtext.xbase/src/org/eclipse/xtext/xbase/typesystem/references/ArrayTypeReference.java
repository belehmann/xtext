/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ArrayTypeReference extends LightweightTypeReference {

	private LightweightTypeReference component;

	protected ArrayTypeReference(TypeReferenceOwner owner, LightweightTypeReference component) {
		super(owner);
		this.component = component;
	}
	
	@Override
	protected JvmTypeReference toTypeReference() {
		JvmGenericArrayTypeReference result = getTypesFactory().createJvmGenericArrayTypeReference();
		result.setComponentType(component.toTypeReference());
		return result;
	}
	
	@Override
	public boolean isResolved() {
		return component.isResolved();
	}

	@Override
	protected LightweightTypeReference doCopyInto(TypeReferenceOwner owner) {
		LightweightTypeReference copiedComponent = component.copyInto(owner);
		return new ArrayTypeReference(owner, copiedComponent);
	}
	
	@Override
	public String toString() {
		return component + "[]";
	}

}
