import sys
input = sys.stdin.readline

N = int(input())
if N <= 100000:
    for i in range(0, N):
        print(N-i)