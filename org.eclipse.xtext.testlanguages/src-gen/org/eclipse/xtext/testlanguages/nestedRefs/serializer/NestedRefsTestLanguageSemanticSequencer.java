/*******************************************************************************
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.nestedRefs.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.testlanguages.nestedRefs.nestedRefs.Doc;
import org.eclipse.xtext.testlanguages.nestedRefs.nestedRefs.NestedRefsPackage;
import org.eclipse.xtext.testlanguages.nestedRefs.nestedRefs.SelfReferingDecl;
import org.eclipse.xtext.testlanguages.nestedRefs.services.NestedRefsTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class NestedRefsTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private NestedRefsTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == NestedRefsPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case NestedRefsPackage.DOC:
				sequence_Doc(context, (Doc) semanticObject); 
				return; 
			case NestedRefsPackage.SELF_REFERING_DECL:
				sequence_SelfReferingDecl(context, (SelfReferingDecl) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Doc returns Doc
	 *
	 * Constraint:
	 *     declarations+=SelfReferingDecl+
	 * </pre>
	 */
	protected void sequence_Doc(ISerializationContext context, Doc semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SelfReferingDecl returns SelfReferingDecl
	 *
	 * Constraint:
	 *     (name=QualifiedName selfRef=[SelfReferingDecl|QualifiedName])
	 * </pre>
	 */
	protected void sequence_SelfReferingDecl(ISerializationContext context, SelfReferingDecl semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, NestedRefsPackage.Literals.SELF_REFERING_DECL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NestedRefsPackage.Literals.SELF_REFERING_DECL__NAME));
			if (transientValues.isValueTransient(semanticObject, NestedRefsPackage.Literals.SELF_REFERING_DECL__SELF_REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NestedRefsPackage.Literals.SELF_REFERING_DECL__SELF_REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSelfReferingDeclAccess().getNameQualifiedNameParserRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getSelfReferingDeclAccess().getSelfRefSelfReferingDeclQualifiedNameParserRuleCall_3_0_1(), semanticObject.eGet(NestedRefsPackage.Literals.SELF_REFERING_DECL__SELF_REF, false));
		feeder.finish();
	}
	
	
}
