#Bernard Kintzing
#TurtleClock
#9/22/2016
#Clock that is useless

import turtle
turns = 12
wn = turtle.Screen()
wn.bgcolor("magenta3")
turtle.shape("turtle")
turtle.pencolor("green3")
turtle.stamp()
turtle.pu()

while(turns != 0):
    turtle.forward(130)
    turtle.pd()
    turtle.forward(10)
    turtle.pu()
    turtle.forward(15)
    turtle.pd()
    turtle.stamp()
    turtle.pu()
    turtle.forward(-155)
    turtle.right(30)
    turns = turns - 1
