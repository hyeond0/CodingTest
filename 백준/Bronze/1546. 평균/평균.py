import sys
input = sys.stdin.readline
sum = 0
prevsum = 0
N = int(input())
score = list(map(int, input().split()))
M = max(score)
for i in range(len(score)):
    score[i] = score[i]/M*100
    sum += score[i] 
avg = sum / len(score)
print(avg)