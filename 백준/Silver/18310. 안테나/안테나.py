n = int(input())
pos_list = list(map(int, input().split()))
pos_list.sort()

print(pos_list[(n - 1) // 2])