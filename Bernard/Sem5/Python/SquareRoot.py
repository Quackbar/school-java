#Square Root
#10/10/2016
#This program does stuff

n = int(input("Enter the number you wish us to guess the sqaure root of: "))

def mySqrt(n):
    oldguess = n/2
        
    for i in range(20):
        newguess = (1/2) * (oldguess + (n/oldguess))
        oldguess = newguess
        i = i + i

    print(str(newguess))

mySqrt(n)
    
