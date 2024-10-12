#include<stdio.h>

void main()
{
    int size,i;
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
    int key;
    printf("Enter the number to be Search : ");
    scanf("%d",&key);
    
    int mid,low,high;
    low=0;
    high=size-1;
    

    while(low<=high)
    {
        mid=low+(high-low)/2;

        if(arr[mid]==key)
        {
            printf("Element %d found position %d",key,mid+1);
            break;
        }
        else if(arr[mid]<key)
        {
            low=mid+1;
        }
        else
        {
            high=mid-1;
        }
    }

}