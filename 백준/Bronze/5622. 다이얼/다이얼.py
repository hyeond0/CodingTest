word = input()
time = 0
for i in range(len(word)):
    word_asci = ord(word[i])
    if word_asci < 80:
        time += (word_asci-65) // 3 + 3
    elif word_asci <84:
        time += 8
    elif word_asci<87:
        time += 9
    else:
        time += 10
print(time)