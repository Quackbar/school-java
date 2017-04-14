#Bernard Kintzing
#Modrian Art

import turtle
import random

rect = int(input("Enter the number of rectangle you want: "))
width = int(input("Enter the max width: "))
width = max(width,10)
height = int(input("Enter the max height: "))
height = max(height,10)

turtle.colormode(255)
turtle.speed(0)
wn = turtle.Screen()
wn.bgcolor("black")

def ranValues(small, large):
    a = random.randint(small,large)
    return a

def drawRect(turt, height, width):
    turtle.pd()
    turtle.begin_fill()
    for n in range(2):
        turtle.forward(width)
        turtle.right(90)
        turtle.forward(height)
        turtle.right(90)
    turtle.end_fill()
    turtle.setheading(0)

for i in range(rect):
    r = ranValues(0,255)
    g = ranValues(0,255)
    b = ranValues(0,255)
    x = ranValues(-500,500)
    y = ranValues(-400,400)
    w = ranValues(5,width)
    h = ranValues(5,height)
    turtle.pu()
    turtle.goto(x,y)
    #theta = x*2+90
    #turtle.setheading(theta)
    turtle.fillcolor(r,g,b)
    turtle.pencolor(r,g,b)
    drawRect(turtle, h, w)
    i= i+1

turtle.hideturtle()
