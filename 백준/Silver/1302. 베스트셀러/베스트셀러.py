book_list = []
N = int(input())
for _ in range(N):
    book_list.append(input())

book_set = set(book_list)
max_list = []
max_count = 0
for name in book_set:
    if max_count < book_list.count(name):
        if max_list:
            max_count = book_list.count(name)
            max_list.pop()
            max_list.append(name)
        else:
            max_count = book_list.count(name)
            max_list.append(name)
    elif max_count == book_list.count(name):
        max_list.append(name)
        max_list.sort()
        max_list.pop(1)
print(max_list[0])