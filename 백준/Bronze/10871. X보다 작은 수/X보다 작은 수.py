import sys
input = sys.stdin.readline

N,X = map(int, input().split())
if 1 <= N <= 10000 and 1<= X <= 10000:
    A = list(map(int, input().split()))
    if len(A) == N:
        for i in range(0,N):
            if A[i] < X:
                print(A[i], end=' ')