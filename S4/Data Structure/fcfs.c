#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct process
{
	char name[20];
	int at,tt,bt,wt,ct,status;
};
struct process p[20],temp;
struct done
{
	char name[20];
	int st,ct;
};
struct done d[20];
void main()
{
	int i,j,n,num,idle=0;
	float avwt=0,avtt=0;
	printf("Enter the Number of Process :");
	scanf("%d",&n);
	
	for(i=0;i<n;i++)
	{
		printf("Enter the name of process :");
		scanf("%s",p[i].name);
		printf("Enter the arrival time :");
		scanf("%d",&p[i].at);
		printf("Enter the burst time :");
		scanf("%d",&p[i].bt);
		p[i].status=0;
	}
	
	for(i=0;i<n;i++)
	{
		for(j=0;j<n-i-1;j++)
		{
			if(p[j].at>p[j+1].at)
			{
				temp=p[j];
				p[j]=p[j+1];
				p[j+1]=temp;
			}
		}
	}
	
	for(i=0,j=0,num=0;j<n;)
	{
		if(p[j].at<=i && p[j].status==0)
		{
			if(idle==1)
			{
				d[num].ct=i;
				num++;
				idle=0;
			}
			strcpy(d[num].name,p[j].name);
			d[num].st=i;
			d[num].ct=i+p[j].bt;
			p[j].wt=d[num].st-p[j].at;
			p[j].tt=p[j].wt+p[j].bt;
			p[j].ct=d[num].ct;
			i=d[num].ct;
			p[j].status=1;
			j++;
			num++;
		}
		else if(idle=0)
		{
			strcpy(d[num].name,"idle");
			d[num].st=i;
			i++;
			idle=1;
		}
		else
		{
			i++;
		}
	}
	printf("Process Name, Completion Time(ms), Waiting Time(ms), Turnaround 	Time(ms)");
	for(i=0;i<n;i++)
	{
		printf("\n\t%s\t\t%d\t\t%d\t\t%d",p[i].name,p[i].ct,p[i].wt,p[i].tt);
		avwt+=p[i].wt;
		avtt+=p[i].tt;
	}
	printf("\nGantt Chart\n");
	for(i=0;i<n;i++)
	{
		printf("\t");
		printf("%s",d[i].name);
	}
	printf("\n");
	for(i=0;i<num;i++)
	{
		printf("   %d\t",d[i].st);
	}
	printf("%d",d[num-1].ct);
	printf("\nAverage Waiting Time : %f\nAverage Turnaround Time :%f",(avwt/n),(avtt/n));
}