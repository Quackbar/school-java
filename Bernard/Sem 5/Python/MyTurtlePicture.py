#Bernard Kintzing
#MyTurtlePicture
#9/22/2016

import turtle
from random import randint

turtle.speed(0)
turtle.fillcolor('red2')

smithHead = 360
kidHead = 360
fireAngle = 160

#Smith Creation
turtle.pu()
turtle.goto(-220, 200)
while(smithHead != 0):

    if(int(smithHead) < 360 and int(smithHead)  > 270):
        x = turtle.xcor()
        y = turtle.ycor()
        distance = (360 - int(smithHead))
        turtle.forward(-(int(distance)))
        turtle.goto(x,y)
        
    if(int(smithHead) < 110 and int(smithHead)  > 65):
        turtle.pu()
        smithHead = smithHead - 1
        turtle.forward(-1)
        turtle.left(1)
        print(str(smithHead) + "If")
        print(turtle.xcor())
        print(turtle.ycor())

    else: 
        turtle.pd()
        turtle.forward(-1)
        turtle.left(1)
        smithHead = smithHead - 1
        print(smithHead)

turtle.pu()
turtle.goto(-166, 124)
turtle.pd()
turtle.right(25)
turtle.forward(-40)
turtle.left(60)
turtle.forward(43)
turtle.pu()
turtle.goto(-220,85)
turtle.pd()
turtle.goto(-220, -140)
turtle.right(80)
turtle.forward(90)
turtle.goto(-220, -140)
turtle.right(85)
turtle.forward(90)
turtle.pu()
turtle.goto(-220, -10)
turtle.pd()
turtle.right(90)
turtle.forward(80)
turtle.goto(-220, -10)
turtle.left(250)
turtle.forward(80)
turtle.pu()
turtle.goto(-190, 166)
turtle.pd()
turtle.left(150)
turtle.begin_fill()
turtle.forward(15)
turtle.right(90)
turtle.forward(15)
turtle.right(135)
turtle.forward(21)
turtle.end_fill()


#Kid Creation
turtle.pu()
turtle.goto(110, 187)
turtle.pd()
while(kidHead != 0):
        
        turtle.forward(-1)
        turtle.left(1)
        kidHead = kidHead - 1
        print(kidHead)
        print(turtle.xcor())
        print(turtle.ycor())
turtle.pu()
turtle.goto(70,90)
turtle.pd()
turtle.goto(70, -140)
turtle.right(0)
turtle.forward(90)
turtle.goto(70, -140)
turtle.right(85)
turtle.forward(90)
turtle.pu()
turtle.goto(70, -10)
turtle.pd()
turtle.right(90)
turtle.forward(80)
turtle.goto(70, -10)
turtle.left(250)
turtle.forward(80)
turtle.pu()

#Fire
turtle.pu()
turtle.goto(-175, 144)
turtle.pensize(2)
while(fireAngle != 0):

    if(fireAngle % 2 == 0):
        turtle.pencolor('red1')

    else:
        turtle.pencolor('gold')

    randY = randint(117, 197)
    randX = randint(30, 50)
    turtle.goto(-175, 144)
    turtle.pd()
    turtle.goto(randX, randY)
    turtle.right(5)
    fireAngle = fireAngle - 5
    turtle.pu()


