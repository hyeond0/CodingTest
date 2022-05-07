import sys
input = sys.stdin.readline

test = int(input())
for i in range(test):
    score = 0
    count = 0
    a = list(input())
    for j in range(0,len(a)):
        if a[j] == 'O': count += 1
        else: count = 0
        score += count
    print(score)