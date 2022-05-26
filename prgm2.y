%{
#include<stdio.h>
#include<stdlib.h>
int yylex();
int yyerror();
%}
%token ENTER A B
%%
Stmt: s ENTER { printf("valid grammer\n"); exit(0); }
	s: c B | B
	c: A c | A
	;
%%
void main() {
	printf("Enter the string:");
	yyparse();
}
int yyerror() {
	printf("invalid grammer\n");
	return 0;
}	

/* 
anb
	s: c B | B
	c: A c | A
anbn	
	s: A s1 B
	s1: A s1 B | ;
abn
	s: A s1 B | A
	s1: s1 B |  ;
	
*/
