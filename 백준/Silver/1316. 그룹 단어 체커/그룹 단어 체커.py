N = int(input())
word_list = []
word_bool = True
count = 0
for i in range(N):
    word = input()
    word_bool=True
    for j in range(len(word)-1):
        if word[j] == word[j+1]:
            pass
        elif word[j+1:].find(word[j]) != -1:
            word_bool = False
    if word_bool == True:
        count += 1
print(count)