
package dhbw.schneider.SpracheX;

import java_cup.runtime.*;
import java.io.IOException;
import dhbw.schneider.SpracheX.Token.*;


// import dhbw.schneider.SpracheX.SpracheXSym;
// import static dhbw.schneider.SpracheX.SpracheXSym.*;

%%

%class SpracheXLex

%unicode
%line
%column
%type Token

// %public
%final
// %abstract

// %cupsym SpracheXSym
// %cup
// %cupdebug

%init{
	// TODO: code that goes to constructor
%init}

%{

	private Token tokenize(String type){
		return Token.tokenize(TokenType.valueOf(type), yyline, yycolumn, yytext());
	}
	
	private Token invalidToken(){
		return tokenize("_INVALID");
	}

	private void error()
	throws IOException
	{
		throw new IOException("illegal text at line = "+yyline+", column = "+yycolumn+", text = '"+yytext()+"'");
	}
%}


WS			= 	[ \t\b\r\n]

// Keywords
PROGRAM		= 	Program|PROGRMM|program
BEGIN		= 	Begin|BEGIN|begin
END			= 	End|END|end
TYPE		= 	float|int|string
READ		= 	read
WRITE		= 	write
PRINT		= 	print

VARIABLE	= 	{CHAR}{ALPHANUM}*
ALPHANUM	= 	{CHAR}|{DIGIT}
CHAR		= 	{CHAR_UPPER}|{CHAR_LOWER}
CHAR_UPPER	= 	[A-Z]
CHAR_LOWER	= 	[a-z]
DIGIT		= 	[0-9]

FLOAT		= [1-9][0-9]*{FRACTION}?{EXP}?
EXP			= \^[0-9]\.?[0-9]*
FRACTION	= \.?[0-9]*

// Operators
ASSIGN		= 	:=
PLUS		= 	\+
MINUS		= 	-
MULTIPLY	= 	\*
DIVIDE		= 	\/
COLON		= 	:
SEMICOLON	= 	;

ENDDOT		= 	\.

ANY			= 	[^]


%%

{WS}+		{ /*eat whitespace*/ }
{PROGRAM}	{	return tokenize("PROGRAM"); }
{BEGIN}		{	return tokenize("BEGIN"); }
{END}		{	return tokenize("END"); }
{TYPE}		{	return tokenize("TYPE"); }
{READ}		{	return tokenize("READ"); }
{PRINT}		{	return tokenize("PRINT"); }

{DIGIT}+	{	return tokenize("NUMBER"); }
{FLOAT} 	{	return tokenize("FLOAT"); }

{VARIABLE}	{	return tokenize("VARIABLE"); }

{ASSIGN}	{	return tokenize("ASSIGN"); }
{PLUS}		{	return tokenize("PLUS"); }
{MINUS}		{	return tokenize("MINUS"); }
{MULTIPLY}	{	return tokenize("MULTIPLY"); }
{DIVIDE}	{	return tokenize("DIVIDE"); }
{COLON}		{	return tokenize("COLON"); }
{SEMICOLON}	{	return tokenize("SEMICOLON"); }

{ENDDOT}	{	return tokenize("ENDDOT"); }
{ANY}		{	return invalidToken(); }
<<EOF>>		{ 	return tokenize("_EOF"); }

