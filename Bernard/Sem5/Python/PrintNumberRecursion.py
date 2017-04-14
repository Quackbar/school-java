def printNumbers(beginNumber):
    print()
    for i in range(beginNumber, 0, -1):
        print(str(i) + ' ',end='')
    if(beginNumber-1 >= 0):
        printNumbers(beginNumber-1)

b = int(input("Input a number: "))
printNumbers(b)
                  
