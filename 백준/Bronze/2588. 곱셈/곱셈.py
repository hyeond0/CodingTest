A = int(input())
B = int(input())
if (A<1000 or B< 1000):
    print(A*((B%100)%10))
    print(A*(int(B%100/10)))
    print(A*(int(B/100)))
    print(A*B)