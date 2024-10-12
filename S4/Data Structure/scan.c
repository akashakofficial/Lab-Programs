#include<stdio.h>
#include<stdlib.h>
void main()
{
    int req,i,j,temp,head,headcopy,cylinder,seektime;
    printf("Enter the number of requests : ");
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

    printf("Enter the number of Cyclinder : ");
    scanf("%d",&cylinder);
    cylinder=cylinder-1;

    for(i=0;i<req;i++)
    {
        for(j=0;j<req-i-1;j++)
        {
            if(reqarr[j]>reqarr[j+1])
            {
                temp=reqarr[j];
                reqarr[j]=reqarr[j+1];
                reqarr[j+1]=temp;
            }
        }
    }

    int st1=cylinder-head;
    int st2=(cylinder-reqarr[0]);
    seektime=st1+st2;

    printf("Total Seektime : %d",seektime);
}