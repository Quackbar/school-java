print("Compound Interest :")
amount = input('Enter the principal amount: $')
amount = float(amount)
rate = input('Enter percentage rate : ')
time = input('Enter number of years: ')
time = float(time)
compoundTimes = input('Number of times interest will be compounded each year: ')
compoundTimes = float(compoundTimes)

total_amount = amount * ((1 + ((float(rate)/100))/4)**(compoundTimes*time))
print('\nTotal Amount = $%0.2f' %total_amount)
compound_interest = total_amount - amount
print('Compound Interest = $%0.2f' %compound_interest)
