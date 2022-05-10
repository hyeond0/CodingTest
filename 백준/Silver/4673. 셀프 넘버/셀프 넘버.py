snum = []
def selfnum(n):
    num = str(n)
    for j in num:
        n += int(j)
    return n


for i in range(1,10001):
    result = selfnum(i)
    snum += [result,]

set(snum)

for i in range(1,10001):
    if (snum.count(i)== False):
        print(i)