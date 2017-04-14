##import random
##
##hexa = "0123456789ABCDEF"
##userInput = " "
##
##def is_hex_digit(hexa):
##    hexadecimal = ""
##    for i in range(6):
##        thing = random.randint(0,len(hexa))
##        hexadecimal = hexadecimal + (hexa[thing])
##
##    return hexadecimal
##    
##hexadecimal = is_hex_digit(hexa)
##
##while(userInput != hexadecimal):
##    userInput = input('Enter your hexadecimal guess: ')
##    if(userInput != hexadecimal):
##        print('Try Again')
##    else:
##        print('Good Job')

import random
userInput = " "
hexa = "0123456789ABCDEF"

def is_hex_digit(hexa): 
    thing = random.randint(0,len(hexa))
    ranHex = (hexa[thing])

    return ranHex

hexadecimal = is_hex_digit(hexa)

while(userInput != hexadecimal):
    userInput = input('Enter your hexadecimal guess from the list 0123456789ABCDEF: ')
    if(userInput == hexadecimal):
        print('Good Job')


