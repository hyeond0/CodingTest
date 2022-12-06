from collections import deque
import sys
input = sys.stdin.readline
n, m, k, x = map(int, input().split())

graph = [[] for _ in range(n + 1)]

# 모든 도로 정보 입력 받기
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

count = 0
booldfs = False

visited = [-1] * (n+1)
visited[x] = 0


def dfs(x):
    queue = deque([])
    queue.append((x))

    while queue:
        x = queue.popleft()
        for i in graph[x]:
            if visited[i] == -1:
                queue.append(i)
                visited[i] = visited[x] + 1


dfs(x)
for i in range(1, n+1):
    if visited[i] == k:
        print(i)
        booldfs = True

if booldfs == False:
    print(-1)
