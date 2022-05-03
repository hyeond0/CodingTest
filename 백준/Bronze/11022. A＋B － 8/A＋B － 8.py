import sys
input = sys.stdin.readline

T = int(input())
number = 1
for i in range(0,T):
    A,B = map(int,input().split())
    print("Case #%d: %d + %d = %d" %(number,A,B,A+B))
    number +=1