H,M = map(int, input().split())
if (0 <= H <= 23 and 0 <= M <= 59):
    if (M-45) < 0:
        H = H - 1
        M = 60+(M-45)
        if H < 0:
            H = 24 + H
            print(H, M)
        else:
            print(H, M)
    else:
        print(H, M-45)