#Area of Circle
#10/10/2016
#This program does stuff

import math
pi = math.pi

radius = input('Input the radius of the circle: ')
radius = float(radius)

def AreaOfCircle(r):
    area = (pi*r**2)
    area = str(area)
    return area

print(AreaOfCircle(radius))
