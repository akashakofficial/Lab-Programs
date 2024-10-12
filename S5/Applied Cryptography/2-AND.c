#include<stdio.h>
#include<string.h>
void main()
{
	char input[]="Hello World";
	int len=strlen(input);
	
	printf("AND : ");
	for(int i=0;i<len;i++)
	{
		printf("%c",input[i]&127);
	}
	printf("\n");
	
	printf("OR : ");
	for(int i=0;i<len;i++)
	{
		printf("%c",input[i]|127);
	}
	printf("\n");
	
	printf("XOR : ");
	for(int i=0;i<len;i++)
	{
		printf("%c",input[i]^127);
	}
	printf("\n");
}
