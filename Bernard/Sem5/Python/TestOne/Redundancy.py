#Redundancy
#Bernard Kintzing
#10/18/2016

import turtle
turt = turtle.Turtle()

for i in range(8):
    turt.forward(150)
    turt.backward(150)
    turt.left(360/8)
turt.hideturtle()
