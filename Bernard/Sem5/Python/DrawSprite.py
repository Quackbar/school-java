#DrawSprite
#Bernard Kintzing
#10/13/16

import turtle

size = float(input('Enter a size for the Turtle: '))
numLegs = int(input('Enter how many legs you want: '))
legLen = int(input('How long do you want the legs to be: '))

screen = turtle.Screen()
#foot = "foot.png"
#face = "face.png"
#screen.addshape("foot")
#screen.addshape("face")
#screen.register_shape("Arrow",((0,10),(-10,0),(-5,0),(-5,-25),(5,-25),(5,0),(10,0),(0,10))) 


def drawSprite(gary, size, numLegs, legLen):
    gary.pu()
    gary.goto(0,0)
    gary.shapesize(size)
    gary.shape('circle')
    gary.stamp()
    gary.shapesize(1)
    gary.pensize(1)
    
    degree = 360/numLegs
    radius = ((21*size)/2)
    

    for i in range(numLegs):
        turtle.goto(0,0)
        turtle.right(degree)
        turtle.pu()
        turtle.forward(radius - 10)
        turtle.pd()
        turtle.forward(legLen)
        if(i == 0):
            turtle.shape('circle')
            turtle.stamp()
        else:
            turtle.shape('circle')
            turtle.stamp()
        turtle.pu()
        i = i + 1
    

drawSprite(turtle, size, numLegs, legLen)
    
    
