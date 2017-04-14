import turtle

def shrinkingSquares(turtle,length,x,y,sub):
    turtle.pu()
    turtle.goto(x + (sub/2),y - (sub/2))
    turtle.pd()
    for i in range(4):
        turtle.forward(length - sub)
        turtle.right(90)
        i += 1

    turtle.setheading(0)
    sub += 20
    if(sub != length):
        shrinkingSquares(turtle,100,x,y,sub)
    

shrinkingSquares(turtle,100,0,0,0)
