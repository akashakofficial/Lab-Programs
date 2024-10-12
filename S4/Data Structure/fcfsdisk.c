#include<stdio.h>
#include<stdlib.h>
void main()
{
    int req,head,headcopy,i,seektime;
    printf("Enter the number of request : ");
    scanf("%d",&req);
    int reqarr[req];

    printf("Enter the Requests\n");
    for(i=0;i<req;i++)
    {
        scanf("%d",&reqarr[i]);
    }

    printf("Enter the head : ");
    scanf("%d",&head);

    headcopy=head;

    for(i=0;i<req;i++)
    {
        seektime=seektime+abs(reqarr[i]-headcopy);
        headcopy=reqarr[i];
    }

    printf("Total Seektime : %d",seektime);
}