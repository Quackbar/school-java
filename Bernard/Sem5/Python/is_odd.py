#Bernard Kintzing
#Finds if the num is odd or not

num =  int(input('Enter a number: '))

def is_odd(n):
        if(n % 2 == 0):  
            print('False')
            return'False'
        else:
            print('True')
            return 'True'

is_odd(num)
