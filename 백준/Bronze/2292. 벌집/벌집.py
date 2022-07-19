N = int(input())
count = 1
circle = 1

while True:
    if N == 1:
        break
    circle += count*6
    count += 1
    if circle >= N:
        break

print(count)