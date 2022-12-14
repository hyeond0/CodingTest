n = int(input())
grade_list = []
for _ in range(n):
    grade = input().split()
    grade_list.append((grade[0], int(grade[1]), int(grade[2]), int(grade[3])))


grade_list = sorted(
    grade_list, key=lambda grade: (-grade[1], grade[2], -grade[3], grade[0]))

for i in range(n):
    print(grade_list[i][0])