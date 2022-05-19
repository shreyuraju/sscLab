%{
#include<stdio.h>
int i=0;
%}
%%
[a-zA-Z0-9]* { i++; }
"\n" { printf("\nThe no. of words is %d",i); i=0; }
%%
int main() {
	printf("Enter the sentences:");
	yylex();
	return 0;
}
