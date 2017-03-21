#PennyConverter
#Bernard Kintzing
#9/13/2016

amount = input('Enter the number of pennies you wish to convert:')
nickels = (int(amount)/5)
nickels = int(nickels)
pennies = (int(amount) - (int(nickels)*5))
print(str(nickels) + ' nickels and ' + str(pennies) + ' pennies')

