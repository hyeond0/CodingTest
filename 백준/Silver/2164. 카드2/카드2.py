from collections import deque
N = int(input())
dq = deque()

for i in range(N):
    dq.append(i+1)

if len(dq) != 1:
    dq.popleft()
    while len(dq) != 1:
        dq.append(dq.popleft())
        dq.popleft()
print(dq[0])