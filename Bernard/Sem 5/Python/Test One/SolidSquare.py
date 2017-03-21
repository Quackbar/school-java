#SolidSquare
#Bernard Kintzing
#10/18/2016

import turtle

wn = turtle.Screen()
wn.bgcolor('gray1')

turtle.pu()
turtle.goto(0,0)
turtle.fillcolor('coral')
turtle.begin_fill()
for i in range(4):
    turtle.forward(100)
    turtle.left(90)
    i = i + 1

turtle.end_fill()

