seed=1212
a=3434
c=4665
m=2**32
def gen():
    global seed
    seed=(a*seed+c)%m
    return seed
for x in range (10):
    print(gen())