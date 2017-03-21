def addNumbers(start):
    total = 0
    print()
    for i in range(start,1,-1):
        total += i
        print(str(total) + '\t',end='')
    if(start > 0):
        addNumbers(start-1)
    print(str(total))

b = int(input('Input a Number: '))
addNumbers(b)
