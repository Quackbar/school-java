#Draw Triangle
#10/10/2016
#This program does stuff

import turtle

sideLen = input('Enter the lenght of the side; ')
sideLen = int(sideLen)
wn = turtle.Screen()
wn.bgcolor('magenta')
turtle = turtle.Turtle()

def drawEquitriangle(someTurtle, someSize):
    someTurtle.pd()

    for i in range(3):
        someTurtle.forward(someSize)
        someTurtle.right(120)

drawEquitriangle(turtle, sideLen)
