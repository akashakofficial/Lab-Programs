def sort(num):
    for i in range (len(num)-1):
        for j in range (i+1,len(num)):
            if num[j]<num[i]:
                num[i],num[j]=num[j],num[i]

numstr=input("Enter the Number(Seperate by comma)")
numlist=[int (n) for n in numstr.split(",")]
sort(numlist)
print(numlist)