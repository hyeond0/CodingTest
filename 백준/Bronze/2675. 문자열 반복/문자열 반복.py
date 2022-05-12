T = int(input())
result = []
for i in range(T):
    A = []
    Z = ''
    R,S = list(map(str, input().split()))
    for j in range(len(S)):
        A.append(S[j]*int(R[0]))
    for f in A:
        Z += f
    result.append(Z)
for i in result:
    print(i)