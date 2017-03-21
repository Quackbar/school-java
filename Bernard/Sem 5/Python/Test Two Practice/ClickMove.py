import turtle
import random

w = turtle.Screen()
turnAngle = [0,60,120,180,240,300]
turtle.colormode(255)
leftBound = - w.window_width() / 2
rightBound = w.window_width() / 2
topBound = w.window_height() / 2
bottomBound = -w.window_height() / 2
turtleX = turtle.xcor()
turtleY = turtle.ycor()

def doStuff(direction):
    num = random.randint(0,5)
    if direction == 1:
        turtle.left(turnAngle[num])    
    else:
        turtle.right(turnAngle[num])
    turtle.forward(50)
    turtle.tracer(1)
    turtleX = turtle.xcor()
    turtleY = turtle.ycor()

def move(x,y):
    turtle.tracer(0)
    r = random.uniform(0,255)
    g = random.uniform(0,255)
    b = random.uniform(0,255)
    turtle.pencolor(int(r),int(g),int(b))
    direction = random.randint(1,2)
    doStuff(direction)
    
    while(turtleX > rightBound or turtleX < leftBound or turtleY > topBound or turtleY < bottomBound):
        turtle.right(180)
        turtle.forward(50)
        doStuff(direction)
        
turtle.onscreenclick(move)
