#Bernard Kintzing
#Random Turn

import turtle
import random

#turnAngle = ['0','60','120','180','240','300']
turnAngle = ['0','90','180','270']
turtle.colormode(255)
wn = turtle.Screen()
t1 = turtle.Turtle()
t1.speed(0)
t2 = turtle.Turtle()
t2.speed(0)

def isInScreen(w, t1):
    leftBound = - w.window_width() / 2
    rightBound = w.window_width() / 2
    topBound = w.window_height() / 2
    bottomBound = -w.window_height() / 2

    turtleX1 = t1.xcor()
    turtleY1 = t1.ycor()

    stillIn = True

    if turtleX1 > rightBound or turtleX1 < leftBound:
        stillIn = False
    if turtleY1 > topBound or turtleY1 < bottomBound:
        stillIn = False
    return stillIn
turtle.tracer(0)

def turnAround(wn, t):
    t.left(180)
    t1.forward(20)

def moveRandom(t):
    #num = random.uniform(0,5)
    num = random.uniform(0,3)
    r = random.uniform(0,255)
    g = random.uniform(0,255)
    b = random.uniform(0,255)
    t.pencolor(int(r),int(g),int(b))
    t.right(int(turnAngle[int(num)]))
    t.forward(20)
    

while(True):
    if((isInScreen(wn, t1) == False) or (t1.xcor()==t2.xcor() and t1.ycor()==t2.ycor())):
        turnAround(wn,t1)

    elif((isInScreen(wn, t2)==False) or (t1.xcor()==t2.xcor() and t1.ycor()==t2.ycor())):
        turnAround(wn,t2)

    moveRandom(t1)
    moveRandom(t2)


        
    
    
    



        

