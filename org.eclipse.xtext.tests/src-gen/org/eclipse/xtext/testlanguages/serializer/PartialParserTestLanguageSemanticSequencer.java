/*******************************************************************************
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.serializer;

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
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChildren;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.Child;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.Children;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.FirstConcrete;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.Named;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.Nested;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.SecondConcrete;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.SomeContainer;
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class PartialParserTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private PartialParserTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == PartialParserTestLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case PartialParserTestLanguagePackage.ABSTRACT_CHILDREN:
				sequence_AbstractChildren(context, (AbstractChildren) semanticObject); 
				return; 
			case PartialParserTestLanguagePackage.CHILD:
				sequence_Child(context, (Child) semanticObject); 
				return; 
			case PartialParserTestLanguagePackage.CHILDREN:
				sequence_Children(context, (Children) semanticObject); 
				return; 
			case PartialParserTestLanguagePackage.FIRST_CONCRETE:
				sequence_FirstConcrete(context, (FirstConcrete) semanticObject); 
				return; 
			case PartialParserTestLanguagePackage.NAMED:
				sequence_Named(context, (Named) semanticObject); 
				return; 
			case PartialParserTestLanguagePackage.NESTED:
				sequence_Nested(context, (Nested) semanticObject); 
				return; 
			case PartialParserTestLanguagePackage.SECOND_CONCRETE:
				sequence_SecondConcrete(context, (SecondConcrete) semanticObject); 
				return; 
			case PartialParserTestLanguagePackage.SOME_CONTAINER:
				sequence_SomeContainer(context, (SomeContainer) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Content returns AbstractChildren
	 *     AbstractChildren returns AbstractChildren
	 *
	 * Constraint:
	 *     abstractChildren+=AbstractChild+
	 * </pre>
	 */
	protected void sequence_AbstractChildren(ISerializationContext context, AbstractChildren semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Child returns Child
	 *
	 * Constraint:
	 *     value=Named
	 * </pre>
	 */
	protected void sequence_Child(ISerializationContext context, Child semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PartialParserTestLanguagePackage.Literals.CHILD__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PartialParserTestLanguagePackage.Literals.CHILD__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getChildAccess().getValueNamedParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Content returns Children
	 *     Children returns Children
	 *
	 * Constraint:
	 *     (children+=Child children+=Child*)
	 * </pre>
	 */
	protected void sequence_Children(ISerializationContext context, Children semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AbstractChild returns FirstConcrete
	 *     FirstConcrete returns FirstConcrete
	 *
	 * Constraint:
	 *     (value=Named referencedContainer=[SomeContainer|ID]?)
	 * </pre>
	 */
	protected void sequence_FirstConcrete(ISerializationContext context, FirstConcrete semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Named returns Named
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_Named(ISerializationContext context, Named semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PartialParserTestLanguagePackage.Literals.NAMED__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PartialParserTestLanguagePackage.Literals.NAMED__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNamedAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Nested returns Nested
	 *
	 * Constraint:
	 *     nested+=SomeContainer+
	 * </pre>
	 */
	protected void sequence_Nested(ISerializationContext context, Nested semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AbstractChild returns SecondConcrete
	 *     SecondConcrete returns SecondConcrete
	 *
	 * Constraint:
	 *     (value=Named referencedChildren+=[Child|ID]?)
	 * </pre>
	 */
	protected void sequence_SecondConcrete(ISerializationContext context, SecondConcrete semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SomeContainer returns SomeContainer
	 *
	 * Constraint:
	 *     (name=ID (nested+=Nested | content+=Content)*)
	 * </pre>
	 */
	protected void sequence_SomeContainer(ISerializationContext context, SomeContainer semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
