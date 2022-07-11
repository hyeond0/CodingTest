A,B = map(int, input().split())

A = str(A)
B = str(B)
new_A = int(A[2]+A[1]+A[0])
new_B = int(B[2]+B[1]+B[0])

if new_A > new_B:
    print(new_A)
else:
    print(new_B)