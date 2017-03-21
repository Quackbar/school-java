#FieldWidth
#Bernard Kintzing
#10/14/2016

name = input('Enter your first name: ')
width = input('Enter the field width: ')

spaces = ((int(width) - int(len(name))) / 2)
space = ''

while(spaces != 0):
    space = ('' + space + ' ')
    spaces = spaces - 1

print('+' + space + name + space + '+')
