#Bernard Kintzing
#Finds the Hypot

import math

sideOne = int(input('Enter the length of the first side: '))
sideTwo = int(input('Enter the length of the second side: '))


def findHypot(sideOne, sideTwo):
    oneS = sideOne**2
    twoS = sideTwo**2
    hypot = oneS + twoS
    hypot = hypot**.5
    print('The hypotenuse is ' + str(hypot))

findHypot(sideOne, sideTwo)
