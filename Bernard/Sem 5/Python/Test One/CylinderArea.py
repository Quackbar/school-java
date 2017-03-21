#CylinderArea
#Bernard Kintzing
#10/18/2016

radius = float(input('Enter the radius of the cylinder: '))
height = float(input('Enter the height of the cylinder: '))
pi = 3.1415

#circleArea = (pi*radius**2)
#print(str(circleArea))
area = (2 * pi * radius * (height + radius))

print('The area of the right cylinder = ' + str(area) + ' (if using 3.1415)')
