import turtle
import math

#turtle.setworldcoordinates(-180,-180,180,180)
turtle.setworldcoordinates(-10,-10,10,10)
turtle.bgcolor('black')
turtle.fillcolor('light cyan')
turtle.pencolor('dark turquoise')
turtle.tracer(0)

x = -10
y = -10
for i in range(19):
    turtle.pu()
    turtle.goto(int(x),int(y))
    turtle.pd()
    turtle.forward(18)
    y = y + 1
    i = i + 1
    
turtle.left(90)
x = -10
y = -10
for i in range(19):
    turtle.pu()
    turtle.goto(int(x),int(y))
    turtle.pd()
    turtle.forward(18)
    x = x + 1
    i = i + 1
    
x = -10
y = 0
turtle.pu()
turtle.pencolor('yellow3')
for i in range(1807):
    x = x + .01
    y = (math.cos(x)) * 4
    turtle.goto(x,y)
    turtle.pd()
