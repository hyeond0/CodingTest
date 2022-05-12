word = input()
list = []
same = False
for i in range(65,91):
    a = word.count(chr(i))
    b = word.count(chr(i+32))
    list += [a+b,]
maximum = max(list)
maxindex = list.index(maximum)
if list.count(maximum) >= 2:
    same = True
if same == True:
    print('?')
else:
    print(chr(maxindex+65))