import sys
input = sys.stdin.readline
tup1 = ()
tup2 = ()
count = 0
for i in range(3):
    num = int(input())
    if 100 <= num < 1000:
        tup1 += (num,)
A = tup1[0]
B = tup1[1]
C = tup1[2]
mul = str(A*B*C)
for i in range(0,10):
    print(mul.count(str(i)))