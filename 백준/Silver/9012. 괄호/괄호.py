T = int(input())
for i in range(T):
    isVPS = True
    stack = []
    for char in input():
        if char == '(':
            stack.append(char)
        else:
            if stack:
                stack.pop()
            else:
                isVPS = False
                break
    if stack:
        isVPS = False
    print('YES' if isVPS else 'NO') 