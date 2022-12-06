def finduv(p, u, v):
    idx = 0
    count0 = 0
    count1 = 0
    for i in range(len(p)):
        if p[i] == "(":
            count0 += 1
        else:
            count1 += 1
        if count0 == count1:
            u += p[idx:i+1]
            v += p[i+1:]
            return u, v


def check(st):
    count = 0
    for i in range(len(st)):
        if st[i] == '(':
            count += 1
        else:
            if count == 0:
                return False
            count -= 1
    if count == 0:
        return True

def solution(p):
    result = ''
    if len(p) == 0:
        return p
    str1 = ''
    str2 = ''
    u, v = finduv(p, str1, str2)
    check_u = check(u)
    check_v = check(v)
    if check_u == True and check_v == True:
        return p
    if check_u == True:
        return u + solution(v)
    else:
        result = '('
        result += solution(v)
        result += ')'
        au = ''
        for i in range(1, len(u)-1):
            au += u[i]
        newu = ''
        for i in range(len(au)):
            if au[i] == '(':
                newu += ')'
            else:
                newu += '('
        result += newu
        return result
