import sys

try:
    number = int(input("Enter number: "))
except:
    print("Invalid input")
else:
    if number <= 1:
        print("Non prime number")
        sys.exit()
    factor = 0
    factors = []

    for i in range(1, number):
        if number % i == 0:
            factor += 1
            factors.append(i)
    factors.append(number)
    if factor > 1:
        print("The number is composite")
        print(f'The factors are {factors}')
        sys.exit()
    print("The number is prime")
    print(f'The factors are {factors}')
