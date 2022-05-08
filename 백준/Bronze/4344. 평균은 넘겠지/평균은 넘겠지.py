import sys
input = sys.stdin.readline

test = int(input())

for i in range(test):
    sum = 0
    count = 0
    percent = 0
    s = [] 
    s = list(map(int, input().split()))
    num = s[0]
    for j in range(0,num):
        sum += s[j+1]
    avg = sum / num
    for j in range(0,num):
        if s[j+1] > avg:
            count+=1
    percent = "{:.3f}".format(float(count/num)*100)
    print(percent+"%")