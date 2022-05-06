import sys
input = sys.stdin.readline
tup1 = ()
tup2 = ()
count = 0
for i in range(10):
    num = int(input())
    if 0 <= num <= 1000:
        tup1 += (num,)
for i in range(0,10):
    tup2 += ((tup1[i] % 42),)

arr = set(tup2)
print(len(arr))