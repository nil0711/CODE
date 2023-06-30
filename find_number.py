def search_number(search_num, numbers):
    if len(numbers) < 1:
        return -1

    mid = len(numbers) // 2
    if search_num == numbers[mid]:
        return mid
    elif search_num > numbers[mid]:
        return search_number(search_num, numbers[mid + 1:])
    else:
        return search_number(search_num, numbers[:mid])



size = int(input('Enter size of list: '))
numbers = []

numbers = sorted(numbers)
while True:
    numbers.append(int(input("Enter number: ")))
    if len(numbers) == size:
        break
    
result = search_number(int(input("Enter number to find: ")),numbers)

print(f'Found number at {result}' if result!=-1 else"Number not found" )

