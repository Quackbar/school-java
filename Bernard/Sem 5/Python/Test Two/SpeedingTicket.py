import random

while(True):
    speed = 0
    while(speed <= 0):
        speed = int(input('How much were you speeding: '))

    if(speed <= 10):
        print('$20')
    elif(speed <= 20):
        print('$40')
    elif(speed <= 30):
        print('$70')
    else:
        extra = random.randint(100,200)
        fine = extra+100
        print('$'+str(fine))
        
