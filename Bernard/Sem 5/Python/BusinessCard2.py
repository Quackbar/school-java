# -----------------------------------------+
# Bernard Kintzing                         |  
# Business Card Program Part II            |
# Last Updated: Sept 20, 2016              |  
# -----------------------------------------+---------------+
# The assignment is to create a customizable business card |  
# ---------------------------------------------------------+

firstName = input('Enter your first Name: ')
lowerFirstName = firstName.lower()
fNameL = len(firstName)
lastName = input('Enter your last Name: ')
lNameL = len(lastName)
spaces1 = (32 - int(fNameL) - int(lNameL))
spaces1 = int(spaces1)
num = input('Enter your number in (XXX) XXX-XXXX format: ')
spaces3 = (10 - int(fNameL))
spaces2 = ''
spaces4 = ''
while(spaces1!=0):
    spaces2 = (''+ spaces2 + ' ')
    spaces1 = spaces1 - 1

while(spaces3!=0):
    spaces4 = (''+ spaces4 + ' ')
    spaces3 = spaces3 - 1

print('+-------------------------------------------------+')
print('|    |                                            |')
print('|    |          ' + lastName + ', ' + firstName + spaces2 + '|' )
print('|  --|          Tribute Liabilities Associate     |')
print('| ---|          Parasail Capital                  |')
print('| ---------                                       |')
print('|  -------      4 Hunger Plaza                    |')
print('|               STE 1400                          |')
print('|               District 12, Panem 00012          |')
print('|                                                 |')
print('| Work: '+ num +'  @: '+ lowerFirstName +'@parasail.com' + spaces4 + '|')
print('+-------------------------------------------------+')

