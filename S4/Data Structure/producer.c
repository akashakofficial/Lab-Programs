#include<stdio.h>
void main()
{
    int row,column,i,j;
    printf("Enter the number of row : ");
    scanf("%d",&row);
    printf("Enter the number of cloumn : ");
    scanf("%d",&column);
    int arr[row][column];
    for(i=0;i<row;i++)
    {
        for(j=0;j<column;j++)
        {
            scanf("%d",&arr[i][j]);
        }
    }

    for(i=0;i<row;i++)
    {
        for(j=0;j<column;j++)
        {
            printf("%d\t",arr[i][j]);
        }
        printf("\n");
    }
}