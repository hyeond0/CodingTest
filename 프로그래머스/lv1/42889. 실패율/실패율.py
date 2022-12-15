def solution(N, stages):
    answer = []
    len_stage = len(stages)
    for stage in range(1,N+1):
        count = stages.count(stage)
        
        if len_stage==0:
            fail = 0
        else:
            fail = count / len_stage
        answer.append((stage, fail))
        len_stage -= count
    
    answer = sorted(answer, key=lambda ans: -ans[1])
    for i in range(len(answer)):
        answer[i] = answer[i][0]
    return answer