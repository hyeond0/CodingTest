import sys
input = sys.stdin.readline
N = int(input())
if 0 <= N <= 99:
    num = N
    count = 0
    while True:
        a = num // 10
        b = num % 10
        num = (b*10)+((a+b)%10)
        if num == N:
            count+=1
            break
        else:
            count+=1
    print(count)