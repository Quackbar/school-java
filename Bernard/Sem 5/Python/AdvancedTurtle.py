import turtle

i=1
n = 1
while 1==1 :
    if n==1 :
        i = i+1
        if i==180 :
            n=0

    if n == 0 :
        i = i-1
        if i==0 :
            n=1
            
    turtle.forward(i)
    turtle.right(i)


