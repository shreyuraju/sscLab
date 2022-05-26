%{
#include<stdio.h>
int yyerror();
int yylex();
int id=0,op=0,digit=0,keyword=0;
extern FILE *yyin;
%}
%token ID OP DIGIT KEYWORD
%%
input: ID input { id++; }
	| ID { id++; }
	| OP input { op++; }
	| OP { op++; }
	| DIGIT input { digit++; }
	| DIGIT { digit++; }
	| KEYWORD input { keyword++; }
	| KEYWORD { keyword++; }
	;
%%
void main() {
	yyin=fopen("sample.txt","r");
	yyparse();
	printf("KEYWORD count is %d\n",keyword);
	printf("ID count is %d\n",id);
	printf("OP count is %d\n",op);
	printf("DIGIT count is %d\n",digit);
}
int yyerror() {
	printf("invalid input\n");
	return 0;
}
