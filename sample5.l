%{
#include<stdio.h>
int nchars,nline, nwords, space;
%}
%%
([ ])+ { space++; }
\n { nline++; }
[^\n \t]* { nwords++; nchars=nchars+yyleng; }
. { nchars++; }

%%
int main() {
	yyin=fopen("name.txt","r");
	//printf("Enter your name:");
	yylex();
	printf("Char count :%d,\nline count:%d,\nword count:%d,\n",nchars,nline,nwords);
	printf("space count:%d\n",space);
	fclose(yyin);
	return 0;
}
