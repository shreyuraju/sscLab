#include<stdio.h>
#include<string.h>
void main() {
	FILE *f1;
	char a[20];
	int i=1,j=0;
	f1=fopen("prgm5.txt","r");
	while(fscanf(f1,"%s",a)!=EOF) {
		if(a[3]=='-') {
			printf("MOV R%d, %c \n",j,a[4]);
			printf("NEG R%d\n",j);
			j++;
		}
		if(isalpha(a[3])) {
			if(isdigit(a[4])) {
				if(a[5]=='+')
					printf("ADD R%d, R%d, R%d\n",j,j-4,j-1);
				else if(a[5]=='-')
					printf("SUB R%d, R%d, R%d\n",j,j-4,j-1);
				else if(a[5]=='*')
					printf("MUL R%d, R%d, R%d\n",j,j-4,j-1);
				else if(a[5]=='/')
					printf("DIV R%d, R%d, R%d\n",j,j-4,j-1);
			}
			else 
			{
				if(a[4]=='+') {
					printf("MOV R%d, %c\n",j++,a[3]);
					printf("MOV R%d, %c\n",j++,a[5]);
					printf("ADD R%d, R%d,R%d\n",j,j-2,j-1);
				}
				else if(a[4]=='-') {
					printf("MOV R%d, %c\n",j++,a[3]);
					printf("MOV R%d, %c\n",j++,a[5]);
					printf("SUB R%d, R%d,R%d\n",j,j-2,j-1);
				}
				else if(a[4]=='*') {
					printf("MOV R%d, %c\n",j++,a[3]);
					printf("MOV R%d, %c\n",j++,a[5]);
					printf("MUL R%d, R%d,R%d\n",j,j-2,j-1);
				}
				else if(a[4]=='/') {
					printf("MOV R%d, %c\n",j++,a[3]);
					printf("MOV R%d, %c\n",j++,a[5]);
					printf("DIV R%d, R%d,R%d\n",j,j-2,j-1);
				}
				j++;
			}
		}
		else{
			if(isdigit(a[3]))
				printf("MOV %c, R%d\n",a[0],j);
		}
	}
}
