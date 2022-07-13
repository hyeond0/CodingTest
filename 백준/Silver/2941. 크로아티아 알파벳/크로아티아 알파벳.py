croa = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=','z=']

word = input()
count = 0

for i in croa:
    word = word.replace(i, 'a')
print(len(word))