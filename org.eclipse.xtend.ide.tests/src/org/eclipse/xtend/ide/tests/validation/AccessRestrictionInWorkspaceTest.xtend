/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.validation

import com.google.inject.Inject
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import org.eclipse.core.resources.IFile
import org.eclipse.emf.common.util.URI
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.util.MergeableManifest2
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtend.ide.tests.WorkbenchTestHelper.*
import static org.eclipse.xtext.common.types.TypesPackage$Literals.*
import static org.eclipse.xtext.xbase.XbasePackage$Literals.*
import static org.eclipse.xtext.xbase.validation.IssueCodes.*

import static extension org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AccessRestrictionInWorkspaceTest extends AbstractXtendUITestCase {
	@Inject
	extension ValidationTestHelper
	@Inject
	extension IResourceSetProvider
	
	@Test
	def void testForbiddenReferenceInOtherProject() throws Exception {
		val xtendFile = 'secondProject/src/Dummy.xtend'.createFile('class D { restricted.A a }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertError(JVM_TYPE_REFERENCE, FORBIDDEN_REFERENCE, 'Access restriction: The type A is not accessible', 'on required project firstProject')
	}
	
	@Test
	def void testForbiddenReferenceInOtherProjectAsMemberFeatureCall() throws Exception {
		val xtendFile = 'secondProject/src/Dummy.xtend'.createFile('class Dummy { public var n = restricted.A.name }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertError(XMEMBER_FEATURE_CALL, FORBIDDEN_REFERENCE, 'Access restriction: The type A is not accessible', 'on required project firstProject')
	}
	@Test
	def void testForbiddenReferenceInOtherProjectAsFeatureCall() throws Exception {
		val xtendFile = 'secondProject/src/Dummy.xtend'.createFile('import restricted.A; class Dummy { public var n = A.name }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertError(XFEATURE_CALL, FORBIDDEN_REFERENCE, 'Access restriction: The type A is not accessible', 'on required project firstProject')
	}
	
	@Test
	def void testDiscouragedReferenceInOtherProject() throws Exception {
		val xtendFile = 'secondProject/src/Dummy.xtend'.createFile('class D { discouraged.B b }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertWarning(JVM_TYPE_REFERENCE, DISCOURAGED_REFERENCE, 'Discouraged access: The type B is not accessible', 'on required project firstProject')
	}
	
	@Test
	def void testForbiddenReferenceInSameProject() throws Exception {
		val xtendFile = 'firstProject/src/Dummy.xtend'.createFile('class D { restricted.A a }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertNoError(DISCOURAGED_REFERENCE)
		c.assertNoError(FORBIDDEN_REFERENCE)
	}
	
	@Test
	def void testDiscouragedReferenceInSameProject() throws Exception {
		val xtendFile = 'firstProject/src/Dummy.xtend'.createFile('class D { discouraged.B b }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertNoError(DISCOURAGED_REFERENCE)
		c.assertNoError(FORBIDDEN_REFERENCE)
	}
	
	@Test
	def void testExportedByOtherProject() throws Exception {
		val xtendFile = 'secondProject/src/Dummy.xtend'.createFile('class D { allowed.C c }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertNoError(DISCOURAGED_REFERENCE)
		c.assertNoError(FORBIDDEN_REFERENCE)
	}
	
	@Test
	def void testForbiddenReferenceInReexportedProject() throws Exception {
		val xtendFile = 'thirdProject/src/Dummy.xtend'.createFile('class D { restricted.A a }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertError(JVM_TYPE_REFERENCE, FORBIDDEN_REFERENCE, 'Access restriction: The type A is not accessible', 'on required project firstProject')
	}
	
	@Test
	def void testDiscouragedReferenceInReexportedProject() throws Exception {
		val xtendFile = 'thirdProject/src/Dummy.xtend'.createFile('class D { discouraged.B b }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertWarning(JVM_TYPE_REFERENCE, DISCOURAGED_REFERENCE, 'Discouraged access: The type B is not accessible', 'on required project firstProject')
	}
	
	@Test
	def void testReexported() throws Exception {
		val xtendFile = 'thirdProject/src/Dummy.xtend'.createFile('class D { allowed.C c }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertNoError(DISCOURAGED_REFERENCE)
		c.assertNoError(FORBIDDEN_REFERENCE)
	}
	
	@Test
	def void testForbiddenReferenceInImplicitLambdaParameter() throws Exception {
		val xtendFile = 'secondProject/src/Dummy.xtend'.createFile('class D { new () { new discouraged.B().accept[] } }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertError(JVM_TYPE_REFERENCE, FORBIDDEN_REFERENCE, 'Access restriction: The type A is not accessible', 'on required project firstProject')
	}
	
	def parse(IFile file) {
		val resourceSet = get(file.project)
		val uri = URI::createPlatformResourceURI(file.fullPath.toString, true)
		val resource =  resourceSet.getResource(uri, true)
		return resource.contents.head as XtendFile
	}
	
	@Before override setUp() throws Exception {
		super.setUp()
		JavaCore::create(createPluginProject("firstProject")).configureExportedPackages
		'firstProject/src/restricted/A.java'.createFile('''package restricted; public class A {}''')
		'firstProject/src/discouraged/B.java'.createFile('''
			package discouraged;
			public class B {
				public interface I {
					void accept(Iterable<restricted.A> a);
				}
				public void accept(I i) {}
			}
		''')
		'firstProject/src/allowed/C.java'.createFile('''package allowed; public class C {}''')
		
		JavaCore::create(createPluginProject("secondProject", "firstProject;visibility:=reexport"))
		JavaCore::create(createPluginProject("thirdProject", "secondProject"))
		waitForBuild
	}
	
	@After override tearDown() throws Exception {
		cleanWorkspace();
	}
	
	private def configureExportedPackages(IJavaProject pluginProject) throws Exception {
		val manifestFile = pluginProject.project.getFile("META-INF/MANIFEST.MF")
		val contents = manifestFile.contents
		val manifest = try {
			new MergeableManifest2(contents)	
		} finally {
			contents.close
		}
		manifest.addExportedPackages(#{'allowed', 'discouraged;x-internal:=true'})
		val out = new ByteArrayOutputStream()
		manifest.write(out)
		val in = new ByteArrayInputStream(out.toByteArray)
		manifestFile.setContents(in, true, true, null)
		return pluginProject
	}
	
}