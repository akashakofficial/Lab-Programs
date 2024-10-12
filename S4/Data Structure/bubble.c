#include<stdio.h>

void main()
{
    int size,i,j,temp;
    printf("Enter the Size of the array : ");
    scanf("%d",&size);
    int arr[size];
    printf("Enter the elements in the array\n");
    for(i=0;i<size;i++)
    {
        scanf("%d",&arr[i]);
    }
    printf("Elements : ");
    for(i=0;i<size;i++)
    {
        printf("%d  ",arr[i]);
    }

    for(i=0;i<size;i++)
    {
        for(j=0;j<size-i;j++)
        {
            if(arr[j]>arr[j+1])
            {
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    }

    printf("Elements : ");
    for(i=0;i<size;i++)
    {
        printf("%d  ",arr[i]);
    }
}