##Bernard Kintzing
##10/6/16
##FunctionPractice.py
##This will draw some squares

import turtle
import random

sideLength = int(input('Input length of side: '))
squareTurtle = turtle.Turtle()
wn = turtle.Screen()
wn.bgcolor('magenta3')
wn.colormode(255)
y = 200

#takes two argument(turtle and length) not fruitful

def drawSquare(gary, length):
    gary.pensize(5)
    gary.pencolor(randomColor())
    gary.fillcolor(randomColor())
    gary.begin_fill()
    for i in range(4):
        gary.forward(length)
        gary.right(90)

    gary.end_fill()

def moveTurtle(gary, x,y):
    gary.pu()
    gary.goto(x,y)
    gary.pd()

#super fruit
def randomColor():
    r = random.randint(0,255)
    g = random.randint(0,255)
    b = random.randint(0,255)
    return (r,g,b)

#function call

drawSquare(squareTurtle, sideLength)
moveTurtle(squareTurtle, -150, -150)
drawSquare(squareTurtle, sideLength/2)

#draw grid of ranom colored squares
moveTurtle(squareTurtle, -200,y)
for column in range(10):
    for row in range(10):
        drawSquare(squareTurtle, 10)
        squareTurtle.forward(10)
    y = y-10
    moveTurtle(squareTurtle, -200,y)
        
