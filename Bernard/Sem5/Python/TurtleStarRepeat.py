#TurtleStarRepeat
#Bernard Kintzing
#10/12/16

import turtle

bgColor = input('Enter a color for the background: ')
penColor = input('Enter a color for the pen: ')
penSize = input('Enter a size for the pen: ')

wn = turtle.Screen()
wn.bgcolor(bgColor)

turtle.pencolor(penColor)
turtle.pensize(penSize)

for i in range (5):
    turtle.pd()
    for i in range(5):
        turtle.forward(50)
        turtle.right(144)
    turtle.pu()
    turtle.forward(350)
    turtle.right(144)
