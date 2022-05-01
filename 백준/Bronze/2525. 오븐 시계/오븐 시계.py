A,B = map(int, input().split())
C = int(input()) # 분 단위

if (0<= A <= 23 and 0 <= B <= 59 and 0 <= C <= 1000):
    if (B + C) >= 60: # 한 시간보다 많을 때
        A = A + ((B+C)//60) # 더해지는 시간만큼 더함
        if A >= 24: #만약 24시 이후로 가면
           A = A-24
    print(A, ((B+C)%60))