#include<stdio.h>
#include<string.h>
void main()
{
	char input[]="Hello World";
	int len=strlen(input);
	
	printf("Result : ");
	for(int i=0;i<len;i++)
	{
		printf("%c",input[i]^0);
	}
	printf("\n");
}
