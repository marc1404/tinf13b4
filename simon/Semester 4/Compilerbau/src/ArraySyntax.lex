package dhbw.schneider.ArraySyntax;

import java_cup.runtime.*;
import java.io.IOException;
// import lex.mich.doch.ArraySyntax.ArraySyntaxSym;
// import static lex.mich.doch.ArraySyntax.ArraySyntaxSym.*;

%%

%class ArraySyntaxLex

%unicode
%line
%column

// %public
%final
// %abstract

// %cupsym ArraySyntaxSym
// %cup
// %cupdebug

%type Token

%init{
	// TODO: code that goes to constructor
%init}

%{

	private Token tokenize(String type){
		return new Token(TokenType.valueOf(type), yyline, yycolumn, yytext());
	}

	private void error()
	throws IOException
	{
		throw new IOException("illegal text at line = "+yyline+", column = "+yycolumn+", text = '"+yytext()+"'");
	}
%}

ANY			=	.
WS	 		= [ \t\b\r\n]
DIGIT 		= [0-9]
ALHANUM		= [0-9a-z]
COMMA		= ,
LSBR		= \[
RSBR		= \]
NULL		= null|NULL
FLOAT		= [1-9][0-9]*{FRACTION}?{EXP}?
SMALL_FLOAT	= \.[0-9]+{EXP}?
EXP			= \^[0-9]\.?[0-9]*
FRACTION	= \.?[0-9]*
DOUBLEDOT	= {DOT}{DOT}
DOT 		= \.
NODD 		= [^.][^.]


%%

{WS}+		{	 }
{NULL}		{	return tokenize("NULL"); }
{DIGIT}+ |
{DIGIT}+ / {NODD} {	return tokenize("NUMBER"); }
{DOUBLEDOT}				{	return tokenize("DOUBLEDOT"); }
{SMALL_FLOAT} 			{	return tokenize("SMALLFLOAT"); }
{FLOAT} / {NODD}		{	return tokenize("FLOAT"); }
{ALHANUM}+	{	return tokenize("NAME"); }
{COMMA}		{	return tokenize("COMMA"); }
{LSBR}		{	return tokenize("LSBR"); }
{RSBR}		{	return tokenize("RSBR"); }
{ANY}		{	return tokenize("_INVALID"); }
<<EOF>>		{ 	return tokenize("_EOF"); }

