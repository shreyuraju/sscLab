%{
#include<stdio.h>
int flag=0;
%}
%%
(""[aA][nN][dD]"")|(""[oO][rR]"") { flag=1; }
%%
int main() {
	printf("Enter the sentence :");
	yylex();
	if(flag==1)
		printf("Compound sentence");
	else
		printf("Simple sentence");
	return 0;
}
