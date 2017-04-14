#Bernard Kintzing
#9/28/2016
#Minecraft

import turtle
from random import randint
ratio = .15
size = 9.523809523809524
pixel = 0
value = 25

colorG = ['darkgreen', 'seagreen', 'forestgreen', 'yellowgreen', 'mediumseagreen', 'green2','green3','green4','OliveDrab1','OliveDrab2','OliveDrab4']
colorB = ['saddlebrown', 'salmon4', 'brown4', 'LightSalmon4', 'OrangeRed4', 'gray2', 'seashell3','lightblue2']
turtle.shape('square')

#turtle.tracer(0)


for turn in range(6):
    print('Turn = ' + str(turn))
    size = size/2
    turtle.shapesize(size)
    pixel = turn * turn
    
    if(turn == 0):
        turtle.goto(0,0)
        randB = randint(0,5)
        ranColorB = colorB[randB]
        turtle.color(ranColorB)
        turtle.pd()
        turtle.stamp()
    
    if(turn == 1):
        value = 25
        pixel = 2
    
    if(turn == 2):
        value = 12.5
        pixel = 4

    if(turn == 3):
        value = 6.25
        pixel = 8

    if(turn == 4):
        value = 3.125
        pixel = 16

    if(turn == 5):
        value = 1.5625
        pixel = 32
        
    if(turn != 0):
        for n in range(pixel):
            if(n == 0):
                x = -50 - (value)
                y = 50 - value
                turtle.pu()
                turtle.goto(x,y)
            else:
                x = -50 - (value)
                
            for m in range(pixel):
                randB = randint(0,7)
                ranColorB = colorB[randB]
                turtle.color(ranColorB)
                x = x + (value * 2)
                turtle.pu()
                turtle.goto(x,y)
                turtle.pd()
                turtle.stamp()

            y = y - (value * 2)
            print(str(x) + ',' + str(y))
    
    
    turn = turn + 1


        





    
