%{
#include<stdio.h>
int count=0;
%}
%%
([ab])* { count++; printf("\nEntered pattern is %s",yytext);  }
%%
int main() {
	printf("enter the pattren :");
	yylex();
	printf(" count:%d",count);
	if(count>0)
		printf("\nPattren matched\n");
	else
		printf("\nPatren is not matched\n");
	return 0;
}
