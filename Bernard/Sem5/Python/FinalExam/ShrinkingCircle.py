##import random
##import turtle
##
##turtle.bgcolor("black")
##turtle.colormode(255)
##turtle.ht()
##
##def shrinkingCircles(t,radius,x,y):
##    r = random.randint(0, 255)
##    g = random.randint(0, 255)
##    b = random.randint(0, 255)
##    turtle.pencolor(r,g,b)
##    turtle.fillcolor(r,g,b)
##    t.pu()
##    t.goto(x,y)
##    t.pd()
##    t.begin_fill()
##    t.tracer(0)
##    t.circle(radius)
##    t.tracer(1)
##    t.end_fill()
##    radius -= 30
##    y += 30
##    if(radius > 5):
##        shrinkingCircles(t,radius, x,y)
##    
##while(True):
##    shrinkingCircles(turtle,275, 0, -275)
##

import random
import turtle

turtle.ht()
turtle.bgcolor("black")

colors = ["red2", "dark orange", "yellow", "green2", "blue", "purple3", "purple4", "MediumPurple1", "deepPink"]

def shrinkingCircles(t,radius,x,y,colorNum, backNum):
    t.pencolor(colors[colorNum])
    t.fillcolor(colors[colorNum])
    if(colorNum < backNum):
        colorNum +=1
    else:
        colorNum -=1
    #colorNum +=1
    t.pu()
    t.goto(x,y)
    t.pd()
    t.begin_fill()
    t.tracer(0)
    t.circle(radius)
    t.tracer(1)
    t.end_fill()
##    radius -= 30
##    y += 30
    if(radius > 5):
        y -= 30
        y += 30
    else:
        y += 30
        y -= 30
    if(radius > 5):    
        shrinkingCircles(t,radius,x,y, colorNum, backNum)
    
shrinkingCircles(turtle,275, 0, -275, 0,8)

