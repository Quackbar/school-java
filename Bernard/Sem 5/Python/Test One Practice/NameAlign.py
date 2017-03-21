#NameAlign
#Bernnard Kintzing
#10/14/16

nameA = ['Kaitlyn', 'Joel', 'Derya', 'Jonathan', 'Hannah', 'Ian']

print('     First Name')
print('---------------')
for i in range(6):
    length = len(nameA[i])
    spaces = (15 - int(length))
    space = ''

    while(spaces != 0):
        space = ('' + space + ' ')
        spaces = spaces - 1
        
    print('' + space + nameA[i])
    i = i + 1

    
    
    
