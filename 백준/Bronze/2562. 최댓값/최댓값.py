import sys
input = sys.stdin.readline
a = ()
for i in range(9):
    num = int(input())
    a += (num,)
print(max(a))
print(a.index(max(a))+1)