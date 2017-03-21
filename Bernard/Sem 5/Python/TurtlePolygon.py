#TurtlePolygon
#Bernard Kintzing
#9/20/16

import turtle

numSides = input('Enter the number of sides you want: ')
numSides = int(numSides)
lenSides = input('Enter the length of the sides you want: ')
lenSides = int(lenSides)
sideColor = input('Enter the color you want the sides to be: ')
fillColor = input('Enter the color you want the fill to be: ')
turnAngle = (360/numSides)

wn = turtle.Screen()
turtle.pencolor(sideColor)
turtle.fillcolor(fillColor)

turtle.begin_fill()
for i in range(numSides):
    turtle.forward(lenSides)
    turtle.right(turnAngle)

turtle.end_fill()
