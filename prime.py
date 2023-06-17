import sys

try:
    number = int(input("Enter number: "))
except:
    print("Invalid input")
else:
    if number < 1:
        print("Invalid number")
        sys.exit()
    factor = 0

    for i in range(1, int(number / 2)):
        if number % i == 0:
            factor += 1
        if factor > 1:
            print("The number is composite")
            sys.exit()

    print("The number is prime")
