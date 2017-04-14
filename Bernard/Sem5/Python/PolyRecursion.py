import turtle

def drawpoly(turtle,length,num,r,g,b):
    wn= turtle.Screen()
    wn.colormode(255)
    turtle.colormode(255)
    turtle.fillcolor(r,g,b)
    turtle.begin_fill()
    for i in range(num):
        turtle.forward(length)
        turtle.left(360/num)
        i = i +1

    turtle.end_fill()
    r = int(r+(255/num/3))
    g = int(g+(255/num/2))
    b = int(b+(255/num/4))
    num = num-1
    if(num > 2):
        drawpoly(turtle, length, num, r,g,b)
        
        
        
    

length = int(input("Enter the length you want: "))
num = int(input("Enter how many sides you want: "))
turtle.pu()
turtle.right(90)
turtle.forward(450)
turtle.left(90)
turtle.pd()

drawpoly(turtle, length, num, 0,0,0)
