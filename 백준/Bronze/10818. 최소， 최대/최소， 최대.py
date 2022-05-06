import sys
input = sys.stdin.readline
N = int(input())
if 1 <= N <= 10000000:
    A = list(map(int, input().split()))
    if len(A) == N:
        print(min(A), max(A))