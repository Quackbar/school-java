#ThreeTurtleLearn
#Bernard Kintzing
#10/25/16

import turtle

#Go to where the mouse is clicked
screen = turtle.Screen()
screen.onclick(turtle.goto)

#Actions based off of key pressed
i = 0

def up():
    while(1 == 1):
        turtle.forward(1)

def down():
    while(1 == 1):
        turtle.forward(-1)

def right():
    while(1 == 1):
        turtle.right(1)

def left():
    while(1 == 1):
        turtle.left(1)

def red():
    turtle.pencolor('red2')

def blue():
    turtle.pencolor('blue')

def green():
    turtle.pencolor('green3')

def space():
    if(i == 0):
        turtle.pu()
        i = i + 1
    if(i == 1):
        turtle.pd()
        i = i - 1
    
screen.listen()

screen.onkeypress(up,'Up')
screen.onkeypress(down,'Down')
screen.onkeypress(right,'Right')
screen.onkeypress(left,'Left')
screen.onkey(red, 'r')
screen.onkey(green, 'g')
screen.onkey(blue, 'b')
screen.onkey(space, 'space')

#Drag the turtle around
turtle.ondrag(turtle.goto)
