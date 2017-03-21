#Thickness = lenght of branch
#Color gets darker as it gets shorter
import turtle
import random

def tree(branchLen,turtle):
    turtle.pensize(branchLen /6)
    if branchLen > 5:
        turtle.bgcolor(random.randint(0,255),random.randint(0,255),random.randint(0,255))
        turtle.pencolor(int(branchLen),int(branchLen/6),int(branchLen))
        turtle.forward(branchLen)
        turtle.right(20)
        tree(branchLen-15,turtle)
        turtle.left(40)
        tree(branchLen-15,turtle)
        turtle.right(20)
        turtle.pu()
        turtle.backward(branchLen)
        turtle.pd()

def main():
    myWin = turtle.Screen()
    turtle.tracer(0)
    turtle.left(90)
    turtle.colormode(255)
    turtle.pu()
    turtle.goto(0,-645)
    turtle.pd()
    tree(180,turtle)
    myWin.exitonclick()

main()
