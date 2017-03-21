import turtle
def drawTriangle(left_x, left_y, top_x, top_y, right_x, right_y,color,myTurtle):
    myTurtle.fillcolor(color)
    myTurtle.up()
    myTurtle.goto(left_x, left_y)
    myTurtle.down()
    myTurtle.begin_fill()
    myTurtle.goto(top_x, top_y)
    myTurtle.goto(right_x, right_y)
    myTurtle.goto(left_x, left_y)
    myTurtle.end_fill()
def midpoint(number_1, number_2):
    return (number_1 + number_2) / 2
def sierpinski(left_x, left_y, top_x, top_y, right_x, right_y, degree, myTurtle):
    colormap = ['blue','red','green','white','yellow','violet','orange']
    drawTriangle(left_x, left_y, top_x, top_y, right_x, right_y, colormap[degree], myTurtle)
    if degree > 0:
        sierpinski(left_x, left_y,
            midpoint(left_x, top_x), midpoint(left_y, top_y),
            midpoint(left_x, right_x), left_y,
            degree - 1, myTurtle)
        sierpinski(midpoint(left_x, top_x), midpoint(left_y, top_y),
            top_x, top_y,
            midpoint(top_x, right_x), midpoint(top_y, right_y),
            degree - 1, myTurtle)
        sierpinski(midpoint(left_x, right_x), right_y,
            midpoint(top_x, right_x), midpoint(top_y, right_y),
            right_x, right_y,
            degree - 1, myTurtle)
def main():
    myTurtle = turtle.Turtle()
    myWin = turtle.Screen()
    myWin.setup(width=500, height=500, startx=None, starty=None)
    sierpinski(-100, -50, 0, 100, 100, -50, 3, myTurtle)
    myWin.exitonclick()

main()
