import sys
input = sys.stdin.readline

N = int(input())
if 1<= N <= 100:
    for i in range(1,N+1):
        print(str("*"*i).rjust(N))