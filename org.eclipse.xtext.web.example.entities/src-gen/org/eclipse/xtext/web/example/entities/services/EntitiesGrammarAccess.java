/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.entities.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;

@Singleton
public class EntitiesGrammarAccess extends AbstractGrammarElementFinder {
	
	public class EntitiesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.entities.Entities.Entities");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cImportSectionAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cImportSectionXImportSectionParserRuleCall_0_0 = (RuleCall)cImportSectionAssignment_0.eContents().get(0);
		private final Assignment cElementsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cElementsAbstractElementParserRuleCall_1_0 = (RuleCall)cElementsAssignment_1.eContents().get(0);
		
		//Entities:
		//	importSection=XImportSection?
		//	elements+=AbstractElement*;
		@Override public ParserRule getRule() { return rule; }
		
		//importSection=XImportSection? elements+=AbstractElement*
		public Group getGroup() { return cGroup; }
		
		//importSection=XImportSection?
		public Assignment getImportSectionAssignment_0() { return cImportSectionAssignment_0; }
		
		//XImportSection
		public RuleCall getImportSectionXImportSectionParserRuleCall_0_0() { return cImportSectionXImportSectionParserRuleCall_0_0; }
		
		//elements+=AbstractElement*
		public Assignment getElementsAssignment_1() { return cElementsAssignment_1; }
		
		//AbstractElement
		public RuleCall getElementsAbstractElementParserRuleCall_1_0() { return cElementsAbstractElementParserRuleCall_1_0; }
	}
	public class AbstractElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.entities.Entities.AbstractElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cPackageDeclarationParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cEntityParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//AbstractElement:
		//	PackageDeclaration | Entity;
		@Override public ParserRule getRule() { return rule; }
		
		//PackageDeclaration | Entity
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//PackageDeclaration
		public RuleCall getPackageDeclarationParserRuleCall_0() { return cPackageDeclarationParserRuleCall_0; }
		
		//Entity
		public RuleCall getEntityParserRuleCall_1() { return cEntityParserRuleCall_1; }
	}
	public class PackageDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.entities.Entities.PackageDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPackageKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameQualifiedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cElementsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cElementsAbstractElementParserRuleCall_3_0 = (RuleCall)cElementsAssignment_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//PackageDeclaration:
		//	'package' name=QualifiedName '{'
		//	elements+=AbstractElement*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'package' name=QualifiedName '{' elements+=AbstractElement* '}'
		public Group getGroup() { return cGroup; }
		
		//'package'
		public Keyword getPackageKeyword_0() { return cPackageKeyword_0; }
		
		//name=QualifiedName
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//QualifiedName
		public RuleCall getNameQualifiedNameParserRuleCall_1_0() { return cNameQualifiedNameParserRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//elements+=AbstractElement*
		public Assignment getElementsAssignment_3() { return cElementsAssignment_3; }
		
		//AbstractElement
		public RuleCall getElementsAbstractElementParserRuleCall_3_0() { return cElementsAbstractElementParserRuleCall_3_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class EntityElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.entities.Entities.Entity");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cEntityKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameValidIDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cExtendsKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cSuperTypeAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cSuperTypeJvmParameterizedTypeReferenceParserRuleCall_2_1_0 = (RuleCall)cSuperTypeAssignment_2_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cFeaturesAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cFeaturesFeatureParserRuleCall_4_0 = (RuleCall)cFeaturesAssignment_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//Entity:
		//	'entity' name=ValidID ('extends' superType=JvmParameterizedTypeReference)? '{'
		//	features+=Feature*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'entity' name=ValidID ('extends' superType=JvmParameterizedTypeReference)? '{' features+=Feature* '}'
		public Group getGroup() { return cGroup; }
		
		//'entity'
		public Keyword getEntityKeyword_0() { return cEntityKeyword_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_1_0() { return cNameValidIDParserRuleCall_1_0; }
		
		//('extends' superType=JvmParameterizedTypeReference)?
		public Group getGroup_2() { return cGroup_2; }
		
		//'extends'
		public Keyword getExtendsKeyword_2_0() { return cExtendsKeyword_2_0; }
		
		//superType=JvmParameterizedTypeReference
		public Assignment getSuperTypeAssignment_2_1() { return cSuperTypeAssignment_2_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getSuperTypeJvmParameterizedTypeReferenceParserRuleCall_2_1_0() { return cSuperTypeJvmParameterizedTypeReferenceParserRuleCall_2_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//features+=Feature*
		public Assignment getFeaturesAssignment_4() { return cFeaturesAssignment_4; }
		
		//Feature
		public RuleCall getFeaturesFeatureParserRuleCall_4_0() { return cFeaturesFeatureParserRuleCall_4_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class FeatureElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.entities.Entities.Feature");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cPropertyParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cOperationParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Feature:
		//	Property | Operation;
		@Override public ParserRule getRule() { return rule; }
		
		//Property | Operation
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Property
		public RuleCall getPropertyParserRuleCall_0() { return cPropertyParserRuleCall_0; }
		
		//Operation
		public RuleCall getOperationParserRuleCall_1() { return cOperationParserRuleCall_1; }
	}
	public class PropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.entities.Entities.Property");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameValidIDParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTypeJvmTypeReferenceParserRuleCall_2_0 = (RuleCall)cTypeAssignment_2.eContents().get(0);
		
		//Property:
		//	name=ValidID ':' type=JvmTypeReference;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ValidID ':' type=JvmTypeReference
		public Group getGroup() { return cGroup; }
		
		//name=ValidID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_0_0() { return cNameValidIDParserRuleCall_0_0; }
		
		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }
		
		//type=JvmTypeReference
		public Assignment getTypeAssignment_2() { return cTypeAssignment_2; }
		
		//JvmTypeReference
		public RuleCall getTypeJvmTypeReferenceParserRuleCall_2_0() { return cTypeJvmTypeReferenceParserRuleCall_2_0; }
	}
	public class OperationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.web.example.entities.Entities.Operation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cOpKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameValidIDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cParamsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cParamsFullJvmFormalParameterParserRuleCall_3_0_0 = (RuleCall)cParamsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cParamsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cParamsFullJvmFormalParameterParserRuleCall_3_1_1_0 = (RuleCall)cParamsAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cColonKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cTypeAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cTypeJvmTypeReferenceParserRuleCall_5_1_0 = (RuleCall)cTypeAssignment_5_1.eContents().get(0);
		private final Assignment cBodyAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cBodyXBlockExpressionParserRuleCall_6_0 = (RuleCall)cBodyAssignment_6.eContents().get(0);
		
		//Operation:
		//	'op' name=ValidID '(' (params+=FullJvmFormalParameter (',' params+=FullJvmFormalParameter)*)? ')' (':'
		//	type=JvmTypeReference)?
		//	body=XBlockExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//'op' name=ValidID '(' (params+=FullJvmFormalParameter (',' params+=FullJvmFormalParameter)*)? ')' (':'
		//type=JvmTypeReference)? body=XBlockExpression
		public Group getGroup() { return cGroup; }
		
		//'op'
		public Keyword getOpKeyword_0() { return cOpKeyword_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_1_0() { return cNameValidIDParserRuleCall_1_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//(params+=FullJvmFormalParameter (',' params+=FullJvmFormalParameter)*)?
		public Group getGroup_3() { return cGroup_3; }
		
		//params+=FullJvmFormalParameter
		public Assignment getParamsAssignment_3_0() { return cParamsAssignment_3_0; }
		
		//FullJvmFormalParameter
		public RuleCall getParamsFullJvmFormalParameterParserRuleCall_3_0_0() { return cParamsFullJvmFormalParameterParserRuleCall_3_0_0; }
		
		//(',' params+=FullJvmFormalParameter)*
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//','
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }
		
		//params+=FullJvmFormalParameter
		public Assignment getParamsAssignment_3_1_1() { return cParamsAssignment_3_1_1; }
		
		//FullJvmFormalParameter
		public RuleCall getParamsFullJvmFormalParameterParserRuleCall_3_1_1_0() { return cParamsFullJvmFormalParameterParserRuleCall_3_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
		
		//(':' type=JvmTypeReference)?
		public Group getGroup_5() { return cGroup_5; }
		
		//':'
		public Keyword getColonKeyword_5_0() { return cColonKeyword_5_0; }
		
		//type=JvmTypeReference
		public Assignment getTypeAssignment_5_1() { return cTypeAssignment_5_1; }
		
		//JvmTypeReference
		public RuleCall getTypeJvmTypeReferenceParserRuleCall_5_1_0() { return cTypeJvmTypeReferenceParserRuleCall_5_1_0; }
		
		//body=XBlockExpression
		public Assignment getBodyAssignment_6() { return cBodyAssignment_6; }
		
		//XBlockExpression
		public RuleCall getBodyXBlockExpressionParserRuleCall_6_0() { return cBodyXBlockExpressionParserRuleCall_6_0; }
	}
	
	
	private final EntitiesElements pEntities;
	private final AbstractElementElements pAbstractElement;
	private final PackageDeclarationElements pPackageDeclaration;
	private final EntityElements pEntity;
	private final FeatureElements pFeature;
	private final PropertyElements pProperty;
	private final OperationElements pOperation;
	
	private final Grammar grammar;
	
	private final XbaseGrammarAccess gaXbase;
	
	private final XtypeGrammarAccess gaXtype;

	@Inject
	public EntitiesGrammarAccess(GrammarProvider grammarProvider,
			XbaseGrammarAccess gaXbase,
			XtypeGrammarAccess gaXtype) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaXbase = gaXbase;
		this.gaXtype = gaXtype;
		this.pEntities = new EntitiesElements();
		this.pAbstractElement = new AbstractElementElements();
		this.pPackageDeclaration = new PackageDeclarationElements();
		this.pEntity = new EntityElements();
		this.pFeature = new FeatureElements();
		this.pProperty = new PropertyElements();
		this.pOperation = new OperationElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.xtext.web.example.entities.Entities".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public XbaseGrammarAccess getXbaseGrammarAccess() {
		return gaXbase;
	}
	
	public XtypeGrammarAccess getXtypeGrammarAccess() {
		return gaXtype;
	}

	
	//Entities:
	//	importSection=XImportSection?
	//	elements+=AbstractElement*;
	public EntitiesElements getEntitiesAccess() {
		return pEntities;
	}
	
	public ParserRule getEntitiesRule() {
		return getEntitiesAccess().getRule();
	}
	
	//AbstractElement:
	//	PackageDeclaration | Entity;
	public AbstractElementElements getAbstractElementAccess() {
		return pAbstractElement;
	}
	
	public ParserRule getAbstractElementRule() {
		return getAbstractElementAccess().getRule();
	}
	
	//PackageDeclaration:
	//	'package' name=QualifiedName '{'
	//	elements+=AbstractElement*
	//	'}';
	public PackageDeclarationElements getPackageDeclarationAccess() {
		return pPackageDeclaration;
	}
	
	public ParserRule getPackageDeclarationRule() {
		return getPackageDeclarationAccess().getRule();
	}
	
	//Entity:
	//	'entity' name=ValidID ('extends' superType=JvmParameterizedTypeReference)? '{'
	//	features+=Feature*
	//	'}';
	public EntityElements getEntityAccess() {
		return pEntity;
	}
	
	public ParserRule getEntityRule() {
		return getEntityAccess().getRule();
	}
	
	//Feature:
	//	Property | Operation;
	public FeatureElements getFeatureAccess() {
		return pFeature;
	}
	
	public ParserRule getFeatureRule() {
		return getFeatureAccess().getRule();
	}
	
	//Property:
	//	name=ValidID ':' type=JvmTypeReference;
	public PropertyElements getPropertyAccess() {
		return pProperty;
	}
	
	public ParserRule getPropertyRule() {
		return getPropertyAccess().getRule();
	}
	
	//Operation:
	//	'op' name=ValidID '(' (params+=FullJvmFormalParameter (',' params+=FullJvmFormalParameter)*)? ')' (':'
	//	type=JvmTypeReference)?
	//	body=XBlockExpression;
	public OperationElements getOperationAccess() {
		return pOperation;
	}
	
	public ParserRule getOperationRule() {
		return getOperationAccess().getRule();
	}
	
	//XExpression:
	//	XAssignment;
	public XbaseGrammarAccess.XExpressionElements getXExpressionAccess() {
		return gaXbase.getXExpressionAccess();
	}
	
	public ParserRule getXExpressionRule() {
		return getXExpressionAccess().getRule();
	}
	
	//XAssignment XExpression:
	//	{XAssignment} feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign value=XAssignment | XOrExpression
	//	(=> ({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign])
	//	rightOperand=XAssignment)?;
	public XbaseGrammarAccess.XAssignmentElements getXAssignmentAccess() {
		return gaXbase.getXAssignmentAccess();
	}
	
	public ParserRule getXAssignmentRule() {
		return getXAssignmentAccess().getRule();
	}
	
	//OpSingleAssign:
	//	'=';
	public XbaseGrammarAccess.OpSingleAssignElements getOpSingleAssignAccess() {
		return gaXbase.getOpSingleAssignAccess();
	}
	
	public ParserRule getOpSingleAssignRule() {
		return getOpSingleAssignAccess().getRule();
	}
	
	//OpMultiAssign:
	//	'+=' | '-=' | '*=' | '/=' | '%=' |
	//	'<' '<' '=' |
	//	'>' '>'? '>=';
	public XbaseGrammarAccess.OpMultiAssignElements getOpMultiAssignAccess() {
		return gaXbase.getOpMultiAssignAccess();
	}
	
	public ParserRule getOpMultiAssignRule() {
		return getOpMultiAssignAccess().getRule();
	}
	
	//XOrExpression XExpression:
	//	XAndExpression (=> ({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOr])
	//	rightOperand=XAndExpression)*;
	public XbaseGrammarAccess.XOrExpressionElements getXOrExpressionAccess() {
		return gaXbase.getXOrExpressionAccess();
	}
	
	public ParserRule getXOrExpressionRule() {
		return getXOrExpressionAccess().getRule();
	}
	
	//OpOr:
	//	'||';
	public XbaseGrammarAccess.OpOrElements getOpOrAccess() {
		return gaXbase.getOpOrAccess();
	}
	
	public ParserRule getOpOrRule() {
		return getOpOrAccess().getRule();
	}
	
	//XAndExpression XExpression:
	//	XEqualityExpression (=> ({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAnd])
	//	rightOperand=XEqualityExpression)*;
	public XbaseGrammarAccess.XAndExpressionElements getXAndExpressionAccess() {
		return gaXbase.getXAndExpressionAccess();
	}
	
	public ParserRule getXAndExpressionRule() {
		return getXAndExpressionAccess().getRule();
	}
	
	//OpAnd:
	//	'&&';
	public XbaseGrammarAccess.OpAndElements getOpAndAccess() {
		return gaXbase.getOpAndAccess();
	}
	
	public ParserRule getOpAndRule() {
		return getOpAndAccess().getRule();
	}
	
	//XEqualityExpression XExpression:
	//	XRelationalExpression (=> ({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpEquality])
	//	rightOperand=XRelationalExpression)*;
	public XbaseGrammarAccess.XEqualityExpressionElements getXEqualityExpressionAccess() {
		return gaXbase.getXEqualityExpressionAccess();
	}
	
	public ParserRule getXEqualityExpressionRule() {
		return getXEqualityExpressionAccess().getRule();
	}
	
	//OpEquality:
	//	'==' | '!=' | '===' | '!==';
	public XbaseGrammarAccess.OpEqualityElements getOpEqualityAccess() {
		return gaXbase.getOpEqualityAccess();
	}
	
	public ParserRule getOpEqualityRule() {
		return getOpEqualityAccess().getRule();
	}
	
	//XRelationalExpression XExpression:
	//	XOtherOperatorExpression (=> ({XInstanceOfExpression.expression=current} 'instanceof') type=JvmTypeReference |
	//	=> ({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpCompare])
	//	rightOperand=XOtherOperatorExpression)*;
	public XbaseGrammarAccess.XRelationalExpressionElements getXRelationalExpressionAccess() {
		return gaXbase.getXRelationalExpressionAccess();
	}
	
	public ParserRule getXRelationalExpressionRule() {
		return getXRelationalExpressionAccess().getRule();
	}
	
	//OpCompare:
	//	'>=' | '<' '=' | '>' | '<';
	public XbaseGrammarAccess.OpCompareElements getOpCompareAccess() {
		return gaXbase.getOpCompareAccess();
	}
	
	public ParserRule getOpCompareRule() {
		return getOpCompareAccess().getRule();
	}
	
	//XOtherOperatorExpression XExpression:
	//	XAdditiveExpression (=> ({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOther])
	//	rightOperand=XAdditiveExpression)*;
	public XbaseGrammarAccess.XOtherOperatorExpressionElements getXOtherOperatorExpressionAccess() {
		return gaXbase.getXOtherOperatorExpressionAccess();
	}
	
	public ParserRule getXOtherOperatorExpressionRule() {
		return getXOtherOperatorExpressionAccess().getRule();
	}
	
	//OpOther:
	//	'->'
	//	| '..<'
	//	| '>' '..'
	//	| '..'
	//	| '=>'
	//	| '>' (=> ('>' '>') | '>') | '<' (=> ('<' '<') | '<' | '=>') | '<>'
	//	| '?:';
	public XbaseGrammarAccess.OpOtherElements getOpOtherAccess() {
		return gaXbase.getOpOtherAccess();
	}
	
	public ParserRule getOpOtherRule() {
		return getOpOtherAccess().getRule();
	}
	
	//XAdditiveExpression XExpression:
	//	XMultiplicativeExpression (=> ({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAdd])
	//	rightOperand=XMultiplicativeExpression)*;
	public XbaseGrammarAccess.XAdditiveExpressionElements getXAdditiveExpressionAccess() {
		return gaXbase.getXAdditiveExpressionAccess();
	}
	
	public ParserRule getXAdditiveExpressionRule() {
		return getXAdditiveExpressionAccess().getRule();
	}
	
	//OpAdd:
	//	'+' | '-';
	public XbaseGrammarAccess.OpAddElements getOpAddAccess() {
		return gaXbase.getOpAddAccess();
	}
	
	public ParserRule getOpAddRule() {
		return getOpAddAccess().getRule();
	}
	
	//XMultiplicativeExpression XExpression:
	//	XUnaryOperation (=> ({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMulti])
	//	rightOperand=XUnaryOperation)*;
	public XbaseGrammarAccess.XMultiplicativeExpressionElements getXMultiplicativeExpressionAccess() {
		return gaXbase.getXMultiplicativeExpressionAccess();
	}
	
	public ParserRule getXMultiplicativeExpressionRule() {
		return getXMultiplicativeExpressionAccess().getRule();
	}
	
	//OpMulti:
	//	'*' | '**' | '/' | '%';
	public XbaseGrammarAccess.OpMultiElements getOpMultiAccess() {
		return gaXbase.getOpMultiAccess();
	}
	
	public ParserRule getOpMultiRule() {
		return getOpMultiAccess().getRule();
	}
	
	//XUnaryOperation XExpression:
	//	{XUnaryOperation} feature=[types::JvmIdentifiableElement|OpUnary] operand=XUnaryOperation
	//	| XCastedExpression;
	public XbaseGrammarAccess.XUnaryOperationElements getXUnaryOperationAccess() {
		return gaXbase.getXUnaryOperationAccess();
	}
	
	public ParserRule getXUnaryOperationRule() {
		return getXUnaryOperationAccess().getRule();
	}
	
	//OpUnary:
	//	"!" | "-" | "+";
	public XbaseGrammarAccess.OpUnaryElements getOpUnaryAccess() {
		return gaXbase.getOpUnaryAccess();
	}
	
	public ParserRule getOpUnaryRule() {
		return getOpUnaryAccess().getRule();
	}
	
	//XCastedExpression XExpression:
	//	XPostfixOperation (=> ({XCastedExpression.target=current} 'as') type=JvmTypeReference)*;
	public XbaseGrammarAccess.XCastedExpressionElements getXCastedExpressionAccess() {
		return gaXbase.getXCastedExpressionAccess();
	}
	
	public ParserRule getXCastedExpressionRule() {
		return getXCastedExpressionAccess().getRule();
	}
	
	//XPostfixOperation XExpression:
	//	XMemberFeatureCall => ({XPostfixOperation.operand=current} feature=[types::JvmIdentifiableElement|OpPostfix])?;
	public XbaseGrammarAccess.XPostfixOperationElements getXPostfixOperationAccess() {
		return gaXbase.getXPostfixOperationAccess();
	}
	
	public ParserRule getXPostfixOperationRule() {
		return getXPostfixOperationAccess().getRule();
	}
	
	//OpPostfix:
	//	"++" | "--";
	public XbaseGrammarAccess.OpPostfixElements getOpPostfixAccess() {
		return gaXbase.getOpPostfixAccess();
	}
	
	public ParserRule getOpPostfixRule() {
		return getOpPostfixAccess().getRule();
	}
	
	//XMemberFeatureCall XExpression:
	//	XPrimaryExpression (=> ({XAssignment.assignable=current} ('.' | explicitStatic?="::")
	//	feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign) value=XAssignment
	//	| => ({XMemberFeatureCall.memberCallTarget=current} ("." | nullSafe?="?." | explicitStatic?="::")) ('<'
	//	typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
	//	feature=[types::JvmIdentifiableElement|IdOrSuper] (=> explicitOperationCall?='(' (memberCallArguments+=XShortClosure
	//	| memberCallArguments+=XExpression (',' memberCallArguments+=XExpression)*)?
	//	')')?
	//	memberCallArguments+=XClosure?)*;
	public XbaseGrammarAccess.XMemberFeatureCallElements getXMemberFeatureCallAccess() {
		return gaXbase.getXMemberFeatureCallAccess();
	}
	
	public ParserRule getXMemberFeatureCallRule() {
		return getXMemberFeatureCallAccess().getRule();
	}
	
	//XPrimaryExpression XExpression:
	//	XConstructorCall | XBlockExpression | XSwitchExpression | XSynchronizedExpression | XFeatureCall | XLiteral |
	//	XIfExpression | XForLoopExpression | XBasicForLoopExpression | XWhileExpression | XDoWhileExpression |
	//	XThrowExpression | XReturnExpression | XTryCatchFinallyExpression | XParenthesizedExpression;
	public XbaseGrammarAccess.XPrimaryExpressionElements getXPrimaryExpressionAccess() {
		return gaXbase.getXPrimaryExpressionAccess();
	}
	
	public ParserRule getXPrimaryExpressionRule() {
		return getXPrimaryExpressionAccess().getRule();
	}
	
	//XLiteral XExpression:
	//	XCollectionLiteral | XClosure | XBooleanLiteral | XNumberLiteral | XNullLiteral | XStringLiteral | XTypeLiteral;
	public XbaseGrammarAccess.XLiteralElements getXLiteralAccess() {
		return gaXbase.getXLiteralAccess();
	}
	
	public ParserRule getXLiteralRule() {
		return getXLiteralAccess().getRule();
	}
	
	//XCollectionLiteral:
	//	XSetLiteral | XListLiteral;
	public XbaseGrammarAccess.XCollectionLiteralElements getXCollectionLiteralAccess() {
		return gaXbase.getXCollectionLiteralAccess();
	}
	
	public ParserRule getXCollectionLiteralRule() {
		return getXCollectionLiteralAccess().getRule();
	}
	
	//XSetLiteral:
	//	{XSetLiteral} '#' '{' (elements+=XExpression (',' elements+=XExpression)*)? '}';
	public XbaseGrammarAccess.XSetLiteralElements getXSetLiteralAccess() {
		return gaXbase.getXSetLiteralAccess();
	}
	
	public ParserRule getXSetLiteralRule() {
		return getXSetLiteralAccess().getRule();
	}
	
	//XListLiteral:
	//	{XListLiteral} '#' '[' (elements+=XExpression (',' elements+=XExpression)*)? ']';
	public XbaseGrammarAccess.XListLiteralElements getXListLiteralAccess() {
		return gaXbase.getXListLiteralAccess();
	}
	
	public ParserRule getXListLiteralRule() {
		return getXListLiteralAccess().getRule();
	}
	
	//XClosure XExpression:
	//	=> ({XClosure}
	//	'[')
	//	=> ((declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)?
	//	explicitSyntax?='|')?
	//	expression=XExpressionInClosure
	//	']';
	public XbaseGrammarAccess.XClosureElements getXClosureAccess() {
		return gaXbase.getXClosureAccess();
	}
	
	public ParserRule getXClosureRule() {
		return getXClosureAccess().getRule();
	}
	
	//XExpressionInClosure XExpression:
	//	{XBlockExpression} (expressions+=XExpressionOrVarDeclaration ';'?)*;
	public XbaseGrammarAccess.XExpressionInClosureElements getXExpressionInClosureAccess() {
		return gaXbase.getXExpressionInClosureAccess();
	}
	
	public ParserRule getXExpressionInClosureRule() {
		return getXExpressionInClosureAccess().getRule();
	}
	
	//XShortClosure XExpression:
	//	=> ({XClosure} (declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)?
	//	explicitSyntax?='|') expression=XExpression;
	public XbaseGrammarAccess.XShortClosureElements getXShortClosureAccess() {
		return gaXbase.getXShortClosureAccess();
	}
	
	public ParserRule getXShortClosureRule() {
		return getXShortClosureAccess().getRule();
	}
	
	//XParenthesizedExpression XExpression:
	//	'(' XExpression ')';
	public XbaseGrammarAccess.XParenthesizedExpressionElements getXParenthesizedExpressionAccess() {
		return gaXbase.getXParenthesizedExpressionAccess();
	}
	
	public ParserRule getXParenthesizedExpressionRule() {
		return getXParenthesizedExpressionAccess().getRule();
	}
	
	//XIfExpression XExpression:
	//	{XIfExpression}
	//	'if' '(' if=XExpression ')'
	//	then=XExpression (=> 'else' else=XExpression)?;
	public XbaseGrammarAccess.XIfExpressionElements getXIfExpressionAccess() {
		return gaXbase.getXIfExpressionAccess();
	}
	
	public ParserRule getXIfExpressionRule() {
		return getXIfExpressionAccess().getRule();
	}
	
	//XSwitchExpression XExpression:
	//	{XSwitchExpression}
	//	'switch' (=> ('(' declaredParam=JvmFormalParameter ':') switch=XExpression ')'
	//	| => (declaredParam=JvmFormalParameter ':')? switch=XExpression) '{'
	//	cases+=XCasePart* ('default' ':' default=XExpression)?
	//	'}';
	public XbaseGrammarAccess.XSwitchExpressionElements getXSwitchExpressionAccess() {
		return gaXbase.getXSwitchExpressionAccess();
	}
	
	public ParserRule getXSwitchExpressionRule() {
		return getXSwitchExpressionAccess().getRule();
	}
	
	//XCasePart:
	//	{XCasePart} typeGuard=JvmTypeReference? ('case' case=XExpression)? (':' then=XExpression | fallThrough?=',');
	public XbaseGrammarAccess.XCasePartElements getXCasePartAccess() {
		return gaXbase.getXCasePartAccess();
	}
	
	public ParserRule getXCasePartRule() {
		return getXCasePartAccess().getRule();
	}
	
	//XForLoopExpression XExpression:
	//	=> ({XForLoopExpression}
	//	'for' '(' declaredParam=JvmFormalParameter ':') forExpression=XExpression ')'
	//	eachExpression=XExpression;
	public XbaseGrammarAccess.XForLoopExpressionElements getXForLoopExpressionAccess() {
		return gaXbase.getXForLoopExpressionAccess();
	}
	
	public ParserRule getXForLoopExpressionRule() {
		return getXForLoopExpressionAccess().getRule();
	}
	
	//XBasicForLoopExpression XExpression:
	//	{XBasicForLoopExpression}
	//	'for' '(' (initExpressions+=XExpressionOrVarDeclaration (',' initExpressions+=XExpressionOrVarDeclaration)*)? ';'
	//	expression=XExpression? ';' (updateExpressions+=XExpression (',' updateExpressions+=XExpression)*)? ')'
	//	eachExpression=XExpression;
	public XbaseGrammarAccess.XBasicForLoopExpressionElements getXBasicForLoopExpressionAccess() {
		return gaXbase.getXBasicForLoopExpressionAccess();
	}
	
	public ParserRule getXBasicForLoopExpressionRule() {
		return getXBasicForLoopExpressionAccess().getRule();
	}
	
	//XWhileExpression XExpression:
	//	{XWhileExpression}
	//	'while' '(' predicate=XExpression ')'
	//	body=XExpression;
	public XbaseGrammarAccess.XWhileExpressionElements getXWhileExpressionAccess() {
		return gaXbase.getXWhileExpressionAccess();
	}
	
	public ParserRule getXWhileExpressionRule() {
		return getXWhileExpressionAccess().getRule();
	}
	
	//XDoWhileExpression XExpression:
	//	{XDoWhileExpression}
	//	'do'
	//	body=XExpression
	//	'while' '(' predicate=XExpression ')';
	public XbaseGrammarAccess.XDoWhileExpressionElements getXDoWhileExpressionAccess() {
		return gaXbase.getXDoWhileExpressionAccess();
	}
	
	public ParserRule getXDoWhileExpressionRule() {
		return getXDoWhileExpressionAccess().getRule();
	}
	
	//XBlockExpression XExpression:
	//	{XBlockExpression}
	//	'{' (expressions+=XExpressionOrVarDeclaration ';'?)*
	//	'}';
	public XbaseGrammarAccess.XBlockExpressionElements getXBlockExpressionAccess() {
		return gaXbase.getXBlockExpressionAccess();
	}
	
	public ParserRule getXBlockExpressionRule() {
		return getXBlockExpressionAccess().getRule();
	}
	
	//XExpressionOrVarDeclaration XExpression:
	//	XVariableDeclaration | XExpression;
	public XbaseGrammarAccess.XExpressionOrVarDeclarationElements getXExpressionOrVarDeclarationAccess() {
		return gaXbase.getXExpressionOrVarDeclarationAccess();
	}
	
	public ParserRule getXExpressionOrVarDeclarationRule() {
		return getXExpressionOrVarDeclarationAccess().getRule();
	}
	
	//XVariableDeclaration XExpression:
	//	{XVariableDeclaration} (writeable?='var' | 'val') (=> (type=JvmTypeReference name=ValidID) | name=ValidID) ('='
	//	right=XExpression)?;
	public XbaseGrammarAccess.XVariableDeclarationElements getXVariableDeclarationAccess() {
		return gaXbase.getXVariableDeclarationAccess();
	}
	
	public ParserRule getXVariableDeclarationRule() {
		return getXVariableDeclarationAccess().getRule();
	}
	
	//JvmFormalParameter types::JvmFormalParameter:
	//	parameterType=JvmTypeReference? name=ValidID;
	public XbaseGrammarAccess.JvmFormalParameterElements getJvmFormalParameterAccess() {
		return gaXbase.getJvmFormalParameterAccess();
	}
	
	public ParserRule getJvmFormalParameterRule() {
		return getJvmFormalParameterAccess().getRule();
	}
	
	//FullJvmFormalParameter types::JvmFormalParameter:
	//	parameterType=JvmTypeReference name=ValidID;
	public XbaseGrammarAccess.FullJvmFormalParameterElements getFullJvmFormalParameterAccess() {
		return gaXbase.getFullJvmFormalParameterAccess();
	}
	
	public ParserRule getFullJvmFormalParameterRule() {
		return getFullJvmFormalParameterAccess().getRule();
	}
	
	//XFeatureCall XExpression:
	//	{XFeatureCall} ('<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
	//	feature=[types::JvmIdentifiableElement|IdOrSuper] (=> explicitOperationCall?='(' (featureCallArguments+=XShortClosure
	//	| featureCallArguments+=XExpression (',' featureCallArguments+=XExpression)*)?
	//	')')?
	//	featureCallArguments+=XClosure?;
	public XbaseGrammarAccess.XFeatureCallElements getXFeatureCallAccess() {
		return gaXbase.getXFeatureCallAccess();
	}
	
	public ParserRule getXFeatureCallRule() {
		return getXFeatureCallAccess().getRule();
	}
	
	//FeatureCallID:
	//	ValidID | 'extends' | 'static' | 'import' | 'extension';
	public XbaseGrammarAccess.FeatureCallIDElements getFeatureCallIDAccess() {
		return gaXbase.getFeatureCallIDAccess();
	}
	
	public ParserRule getFeatureCallIDRule() {
		return getFeatureCallIDAccess().getRule();
	}
	
	//IdOrSuper:
	//	FeatureCallID | 'super';
	public XbaseGrammarAccess.IdOrSuperElements getIdOrSuperAccess() {
		return gaXbase.getIdOrSuperAccess();
	}
	
	public ParserRule getIdOrSuperRule() {
		return getIdOrSuperAccess().getRule();
	}
	
	//XConstructorCall XExpression:
	//	{XConstructorCall}
	//	'new' constructor=[types::JvmConstructor|QualifiedName] (=> '<' typeArguments+=JvmArgumentTypeReference (','
	//	typeArguments+=JvmArgumentTypeReference)* '>')? (=> explicitConstructorCall?='(' (arguments+=XShortClosure
	//	| arguments+=XExpression (',' arguments+=XExpression)*)?
	//	')')?
	//	arguments+=XClosure?;
	public XbaseGrammarAccess.XConstructorCallElements getXConstructorCallAccess() {
		return gaXbase.getXConstructorCallAccess();
	}
	
	public ParserRule getXConstructorCallRule() {
		return getXConstructorCallAccess().getRule();
	}
	
	//XBooleanLiteral XExpression:
	//	{XBooleanLiteral} ('false' | isTrue?='true');
	public XbaseGrammarAccess.XBooleanLiteralElements getXBooleanLiteralAccess() {
		return gaXbase.getXBooleanLiteralAccess();
	}
	
	public ParserRule getXBooleanLiteralRule() {
		return getXBooleanLiteralAccess().getRule();
	}
	
	//XNullLiteral XExpression:
	//	{XNullLiteral} 'null';
	public XbaseGrammarAccess.XNullLiteralElements getXNullLiteralAccess() {
		return gaXbase.getXNullLiteralAccess();
	}
	
	public ParserRule getXNullLiteralRule() {
		return getXNullLiteralAccess().getRule();
	}
	
	//XNumberLiteral XExpression:
	//	{XNumberLiteral} value=Number;
	public XbaseGrammarAccess.XNumberLiteralElements getXNumberLiteralAccess() {
		return gaXbase.getXNumberLiteralAccess();
	}
	
	public ParserRule getXNumberLiteralRule() {
		return getXNumberLiteralAccess().getRule();
	}
	
	//XStringLiteral XExpression:
	//	{XStringLiteral} value=STRING;
	public XbaseGrammarAccess.XStringLiteralElements getXStringLiteralAccess() {
		return gaXbase.getXStringLiteralAccess();
	}
	
	public ParserRule getXStringLiteralRule() {
		return getXStringLiteralAccess().getRule();
	}
	
	//XTypeLiteral XExpression:
	//	{XTypeLiteral} 'typeof' '(' type=[types::JvmType|QualifiedName] arrayDimensions+=ArrayBrackets* ')';
	public XbaseGrammarAccess.XTypeLiteralElements getXTypeLiteralAccess() {
		return gaXbase.getXTypeLiteralAccess();
	}
	
	public ParserRule getXTypeLiteralRule() {
		return getXTypeLiteralAccess().getRule();
	}
	
	//XThrowExpression XExpression:
	//	{XThrowExpression} 'throw' expression=XExpression;
	public XbaseGrammarAccess.XThrowExpressionElements getXThrowExpressionAccess() {
		return gaXbase.getXThrowExpressionAccess();
	}
	
	public ParserRule getXThrowExpressionRule() {
		return getXThrowExpressionAccess().getRule();
	}
	
	//XReturnExpression XExpression:
	//	{XReturnExpression} 'return' -> expression=XExpression?;
	public XbaseGrammarAccess.XReturnExpressionElements getXReturnExpressionAccess() {
		return gaXbase.getXReturnExpressionAccess();
	}
	
	public ParserRule getXReturnExpressionRule() {
		return getXReturnExpressionAccess().getRule();
	}
	
	//XTryCatchFinallyExpression XExpression:
	//	{XTryCatchFinallyExpression}
	//	'try'
	//	expression=XExpression (catchClauses+=XCatchClause+ (=> 'finally' finallyExpression=XExpression)?
	//	| 'finally' finallyExpression=XExpression);
	public XbaseGrammarAccess.XTryCatchFinallyExpressionElements getXTryCatchFinallyExpressionAccess() {
		return gaXbase.getXTryCatchFinallyExpressionAccess();
	}
	
	public ParserRule getXTryCatchFinallyExpressionRule() {
		return getXTryCatchFinallyExpressionAccess().getRule();
	}
	
	//XSynchronizedExpression XExpression:
	//	=> ({XSynchronizedExpression}
	//	'synchronized' '(') param=XExpression ')' expression=XExpression;
	public XbaseGrammarAccess.XSynchronizedExpressionElements getXSynchronizedExpressionAccess() {
		return gaXbase.getXSynchronizedExpressionAccess();
	}
	
	public ParserRule getXSynchronizedExpressionRule() {
		return getXSynchronizedExpressionAccess().getRule();
	}
	
	//XCatchClause:
	//	=> 'catch' '(' declaredParam=FullJvmFormalParameter ')' expression=XExpression;
	public XbaseGrammarAccess.XCatchClauseElements getXCatchClauseAccess() {
		return gaXbase.getXCatchClauseAccess();
	}
	
	public ParserRule getXCatchClauseRule() {
		return getXCatchClauseAccess().getRule();
	}
	
	//QualifiedName:
	//	ValidID (=> '.' ValidID)*;
	public XbaseGrammarAccess.QualifiedNameElements getQualifiedNameAccess() {
		return gaXbase.getQualifiedNameAccess();
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}
	
	//Number hidden():
	//	HEX | (INT | DECIMAL) ('.' (INT | DECIMAL))?;
	public XbaseGrammarAccess.NumberElements getNumberAccess() {
		return gaXbase.getNumberAccess();
	}
	
	public ParserRule getNumberRule() {
		return getNumberAccess().getRule();
	}
	
	///**
	// * Dummy rule, for "better" downwards compatibility, since GrammarAccess generates non-static inner classes, 
	// * which makes downstream grammars break on classloading, when a rule is removed.
	// */ StaticQualifier:
	//	(ValidID '::')+;
	public XbaseGrammarAccess.StaticQualifierElements getStaticQualifierAccess() {
		return gaXbase.getStaticQualifierAccess();
	}
	
	public ParserRule getStaticQualifierRule() {
		return getStaticQualifierAccess().getRule();
	}
	
	//terminal HEX:
	//	('0x' | '0X') ('0'..'9' | 'a'..'f' | 'A'..'F' | '_')+ ('#' (('b' | 'B') ('i' | 'I') | ('l' | 'L')))?;
	public TerminalRule getHEXRule() {
		return gaXbase.getHEXRule();
	}
	
	//terminal INT returns ecore::EInt:
	//	'0'..'9' ('0'..'9' | '_')*;
	public TerminalRule getINTRule() {
		return gaXbase.getINTRule();
	}
	
	//terminal DECIMAL:
	//	INT (('e' | 'E') ('+' | '-')? INT)? (('b' | 'B') ('i' | 'I' | 'd' | 'D') | ('l' | 'L' | 'd' | 'D' | 'f' | 'F'))?;
	public TerminalRule getDECIMALRule() {
		return gaXbase.getDECIMALRule();
	}
	
	//JvmTypeReference:
	//	JvmParameterizedTypeReference => ({JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)*
	//	| XFunctionTypeRef;
	public XtypeGrammarAccess.JvmTypeReferenceElements getJvmTypeReferenceAccess() {
		return gaXtype.getJvmTypeReferenceAccess();
	}
	
	public ParserRule getJvmTypeReferenceRule() {
		return getJvmTypeReferenceAccess().getRule();
	}
	
	//ArrayBrackets:
	//	'[' ']';
	public XtypeGrammarAccess.ArrayBracketsElements getArrayBracketsAccess() {
		return gaXtype.getArrayBracketsAccess();
	}
	
	public ParserRule getArrayBracketsRule() {
		return getArrayBracketsAccess().getRule();
	}
	
	//XFunctionTypeRef:
	//	('(' (paramTypes+=JvmTypeReference (',' paramTypes+=JvmTypeReference)*)? ')')? '=>' returnType=JvmTypeReference;
	public XtypeGrammarAccess.XFunctionTypeRefElements getXFunctionTypeRefAccess() {
		return gaXtype.getXFunctionTypeRefAccess();
	}
	
	public ParserRule getXFunctionTypeRefRule() {
		return getXFunctionTypeRefAccess().getRule();
	}
	
	//JvmParameterizedTypeReference:
	//	type=[JvmType|super::QualifiedName] (=> '<' arguments+=JvmArgumentTypeReference (','
	//	arguments+=JvmArgumentTypeReference)* '>' (=> ({JvmInnerTypeReference.outer=current} '.') type=[JvmType|ValidID] (=>
	//	'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?)*)?;
	public XtypeGrammarAccess.JvmParameterizedTypeReferenceElements getJvmParameterizedTypeReferenceAccess() {
		return gaXtype.getJvmParameterizedTypeReferenceAccess();
	}
	
	public ParserRule getJvmParameterizedTypeReferenceRule() {
		return getJvmParameterizedTypeReferenceAccess().getRule();
	}
	
	//JvmArgumentTypeReference JvmTypeReference:
	//	JvmTypeReference | JvmWildcardTypeReference;
	public XtypeGrammarAccess.JvmArgumentTypeReferenceElements getJvmArgumentTypeReferenceAccess() {
		return gaXtype.getJvmArgumentTypeReferenceAccess();
	}
	
	public ParserRule getJvmArgumentTypeReferenceRule() {
		return getJvmArgumentTypeReferenceAccess().getRule();
	}
	
	//JvmWildcardTypeReference:
	//	{JvmWildcardTypeReference} '?' (constraints+=JvmUpperBound constraints+=JvmUpperBoundAnded*
	//	| constraints+=JvmLowerBound constraints+=JvmLowerBoundAnded*)?;
	public XtypeGrammarAccess.JvmWildcardTypeReferenceElements getJvmWildcardTypeReferenceAccess() {
		return gaXtype.getJvmWildcardTypeReferenceAccess();
	}
	
	public ParserRule getJvmWildcardTypeReferenceRule() {
		return getJvmWildcardTypeReferenceAccess().getRule();
	}
	
	//JvmUpperBound:
	//	'extends' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmUpperBoundElements getJvmUpperBoundAccess() {
		return gaXtype.getJvmUpperBoundAccess();
	}
	
	public ParserRule getJvmUpperBoundRule() {
		return getJvmUpperBoundAccess().getRule();
	}
	
	//JvmUpperBoundAnded JvmUpperBound:
	//	'&' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmUpperBoundAndedElements getJvmUpperBoundAndedAccess() {
		return gaXtype.getJvmUpperBoundAndedAccess();
	}
	
	public ParserRule getJvmUpperBoundAndedRule() {
		return getJvmUpperBoundAndedAccess().getRule();
	}
	
	//JvmLowerBound:
	//	'super' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmLowerBoundElements getJvmLowerBoundAccess() {
		return gaXtype.getJvmLowerBoundAccess();
	}
	
	public ParserRule getJvmLowerBoundRule() {
		return getJvmLowerBoundAccess().getRule();
	}
	
	//JvmLowerBoundAnded JvmLowerBound:
	//	'&' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmLowerBoundAndedElements getJvmLowerBoundAndedAccess() {
		return gaXtype.getJvmLowerBoundAndedAccess();
	}
	
	public ParserRule getJvmLowerBoundAndedRule() {
		return getJvmLowerBoundAndedAccess().getRule();
	}
	
	//JvmTypeParameter:
	//	name=ValidID (constraints+=JvmUpperBound constraints+=JvmUpperBoundAnded*)?;
	public XtypeGrammarAccess.JvmTypeParameterElements getJvmTypeParameterAccess() {
		return gaXtype.getJvmTypeParameterAccess();
	}
	
	public ParserRule getJvmTypeParameterRule() {
		return getJvmTypeParameterAccess().getRule();
	}
	
	//QualifiedNameWithWildcard:
	//	super::QualifiedName '.' '*';
	public XtypeGrammarAccess.QualifiedNameWithWildcardElements getQualifiedNameWithWildcardAccess() {
		return gaXtype.getQualifiedNameWithWildcardAccess();
	}
	
	public ParserRule getQualifiedNameWithWildcardRule() {
		return getQualifiedNameWithWildcardAccess().getRule();
	}
	
	//ValidID:
	//	ID;
	public XtypeGrammarAccess.ValidIDElements getValidIDAccess() {
		return gaXtype.getValidIDAccess();
	}
	
	public ParserRule getValidIDRule() {
		return getValidIDAccess().getRule();
	}
	
	//XImportSection:
	//	importDeclarations+=XImportDeclaration+;
	public XtypeGrammarAccess.XImportSectionElements getXImportSectionAccess() {
		return gaXtype.getXImportSectionAccess();
	}
	
	public ParserRule getXImportSectionRule() {
		return getXImportSectionAccess().getRule();
	}
	
	//XImportDeclaration:
	//	'import' (static?='static' extension?='extension'? importedType=[JvmDeclaredType|QualifiedNameInStaticImport]
	//	(wildcard?='*' | memberName=ValidID) | importedType=[JvmDeclaredType|super::QualifiedName] |
	//	importedNamespace=QualifiedNameWithWildcard) ';'?;
	public XtypeGrammarAccess.XImportDeclarationElements getXImportDeclarationAccess() {
		return gaXtype.getXImportDeclarationAccess();
	}
	
	public ParserRule getXImportDeclarationRule() {
		return getXImportDeclarationAccess().getRule();
	}
	
	//QualifiedNameInStaticImport:
	//	(ValidID '.')+;
	public XtypeGrammarAccess.QualifiedNameInStaticImportElements getQualifiedNameInStaticImportAccess() {
		return gaXtype.getQualifiedNameInStaticImportAccess();
	}
	
	public ParserRule getQualifiedNameInStaticImportRule() {
		return getQualifiedNameInStaticImportAccess().getRule();
	}
	
	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '$' | '_') ('a'..'z' | 'A'..'Z' | '$' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaXtype.getIDRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"'? |
	//	"'" ('\\' . | !('\\' | "'"))* "'"?;
	public TerminalRule getSTRINGRule() {
		return gaXtype.getSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaXtype.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaXtype.getSL_COMMENTRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaXtype.getWSRule();
	}
	
	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaXtype.getANY_OTHERRule();
	}
}
