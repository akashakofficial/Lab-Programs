#include<stdio.h>
#include<string.h>
#include<ctype.h>

char infix[100];
char postfix[100];
char result[100];
int top=-1,size;


void push(char symbol)
{
    if(top==size-1)
    {
        printf("Stack is full!");
    }
    else
    {
        top=top+1;
        result[top]=symbol;
        
    }

}

void intopost()
{
    int i;
    char symbol;
    for(i=0;i<strlen(infix);i++)
    {
        symbol=infix[i];

        switch(symbol)
        {
            case '(':
                push(symbol);

        }
    }
}

void display()
{
        printf("%s",result);
}

void main()
{

    printf("Enter the Name : ");
    scanf("%[^\n]",infix);
    intopost(infix);
    display();
}