#Bernard Kintzing
#SpiralSquare
#9/22/3016

import turtle
length = 30
turns = 40

while(turns != 0):
    turtle.forward(length)
    turtle.left(90)
    length = length + 3
    turns = turns - 1
