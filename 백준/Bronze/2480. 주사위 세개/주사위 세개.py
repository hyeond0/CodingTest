A,B,C = map(int, input().split())

if 1 <= A <= 6 and 1 <= B <= 6 and 1 <= C <= 6:
    if A == B == C:
        print(10000 + A*1000)
    elif A == B != C or A == C != B or B == C != A:
        if A==B:
            print(1000 + A*100)
        elif A==C:
            print(1000 + A*100)
        elif B==C:
            print(1000 + B*100)
    else:
        big = 0
        for i in range(1,7):
            if i == A or i == B or i == C:
                if(big<i):
                    big = i
        print(big * 100)