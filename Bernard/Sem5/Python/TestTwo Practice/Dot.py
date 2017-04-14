import turtle
import random

num = 1

def getDotNum():
    num = int(input('Number of dots: '))
    return num

def moveTurtle(t):
    t.pu()
    x = random.randint(-350,350)
    y = random.randint(-350,350)
    t.goto(x,y)
    t.pd()

def drawDot(t,s,c):
    moveTurtle(turtle)
    turtle.shape('circle')
    turtle.pensize(s)
    turtle.fillcolor(c)
    turtle.pencolor(c)
    turtle.stamp()
    

def getDotInfo(num):
    for i in range(num):
        size = int(input('Dot Size: '))
        color = input('Dot Color: ')
        drawDot(turtle,size,color)

num = getDotNum()
getDotInfo(num)
    
    
