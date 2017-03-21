import turtle

wn = turtle.Screen()

def moveTurtle(t):
    x = int(input('X coordinate: '))
    y = int(input('Y coordinate: '))
    t.pu()
    t.goto(x,y)
    t.pd()


def writeMessage(t,m,fc,sc,f,fs):
    moveTurtle(t)
    for i in range(len(m)):
        if((i%2) == 1):
            turtle.fillcolor(fc)
            turtle.pencolor(fc)
            t.write(m[i],True,align='left',font=(str(f),int(fs),'normal'))
        else:
            turtle.fillcolor(sc)
            turtle.pencolor(sc)
            t.write(m[i],True,align='left',font=(f,fs,'normal'))
        i = 1+1

def getInput():
    bgColor = input('Background Color: ')
    message = input('Message: ')
    font = input('Font: ')
    fontSize = int(input('Font Size: '))
    firstColor = input('First Color: ')
    secondColor = input('Second Color: ')
    wn.bgcolor(bgColor)
    writeMessage(turtle,message,firstColor,secondColor,font,fontSize)
    
getInput()
    
