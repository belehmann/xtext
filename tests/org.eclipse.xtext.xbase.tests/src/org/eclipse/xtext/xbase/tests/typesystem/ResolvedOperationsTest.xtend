/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.common.collect.Iterables
import com.google.common.collect.UnmodifiableIterator
import com.google.inject.Inject
import java.util.AbstractList
import java.util.ArrayList
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.^override.OverrideHelper
import org.eclipse.xtext.xbase.typesystem.^override.ResolvedOperations
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseNewTypeSystemInjectorProvider))
class ResolvedOperationsTest extends AbstractXbaseTestCase {
	
	@Inject
	OverrideHelper overrideHelper
	
	def ResolvedOperations toResolvedOperations(Class<?> type) {
		val typeLiteral = '''typeof(«type.canonicalName»)'''.expression as XTypeLiteral
		val result = overrideHelper.getResolvedOperations(typeLiteral.type as JvmDeclaredType)
		return result
	}
	
	@Test
	def void testArrayListHasNoAbstractMethods() {
		val resolvedOperations = typeof(ArrayList).toResolvedOperations
		val all = resolvedOperations.allOperations
		assertFalse(all.empty)
		all.forEach [
			assertFalse(declaration.isAbstract)
		]
	}
	
	@Test
	def void testIterableIterator() {
		val resolvedOperations = typeof(Iterable).toResolvedOperations
		val all = resolvedOperations.allOperations
		assertFalse(all.empty)
		val iterator = Iterables::getOnlyElement(all.filter [ declaration.isAbstract ])
		assertEquals("java.lang.Iterable.iterator()", iterator.declaration.identifier)
	}
	
	@Test
	def void testUnmodifiableIterator() {
		val resolvedOperations = typeof(UnmodifiableIterator).toResolvedOperations
		val all = resolvedOperations.allOperations
		assertFalse(all.empty)
		assertEquals(all.toString, 2, all.filter [ declaration.isAbstract ].size)
		assertEquals(all.toString, 1 /* remove */ + 6 /* from Object */, all.filter [ declaration.final ].size)
		val declared = resolvedOperations.declaredOperations
		assertEquals(1, declared.size)
	}
	
	@Test
	def void testAbstractList() {
		val resolvedOperations = typeof(AbstractList).toResolvedOperations
		val all = resolvedOperations.allOperations
		assertFalse(all.empty)
		assertEquals(all.toString, 1 /* AbstractList.get */ + 1 /* AbstractCollection.size */, all.filter [ declaration.isAbstract ].size)
		val declared = resolvedOperations.declaredOperations
		assertEquals(1, declared.filter [ declaration.isAbstract ].size)
	}
	
}