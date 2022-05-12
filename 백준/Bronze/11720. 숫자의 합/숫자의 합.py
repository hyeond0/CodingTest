import sys
input = sys.stdin.readline

N = int(input())
if 1 <= N <= 100:
    c = list(input())
    del c[-1]
    if N == len(c):
        sum = 0
        for i in c:
            sum += int(i)
        print(sum)