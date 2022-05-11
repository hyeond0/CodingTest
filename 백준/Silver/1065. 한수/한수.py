import sys
input = sys.stdin.readline

han = 0
N = int(input())
if 0 < N <= 1000:
    if N < 100:
        han = N
    else:
        han = 99
        for i in range(100, N+1):
            i = str(i)
            if int(i[0]) - int(i[1]) == int(i[1]) - int(i[2]) or int(i[1]) - int(i[0]) == int(i[2]) - int(i[1]):
                han+=1
print(han)