#Bernard Kintzing
#Lift Ticket

moneySpent = 0;

def getTickets(budget, moneySpent):
    another = 'y'
    screwUp = False
    while(another == 'y'):
        ticket = input('Enter the type of ticket you want (full or half): ')
        age = int(input('Enter the age of the ticket user: '))
        if(age <= 17 or age >=66):
            if(ticket == 'full'):
                moneySpent = moneySpent + 30
            elif(ticket == 'half'):
                moneySpent = moneySpent + 15
            else:
                screwUp = True;
        else:
            if(ticket == 'full'):
                moneySpent = moneySpent + 45
            elif(ticket == 'half'):
                moneySpent = moneySpent + 22.5
            else:
                screwUp = True;
        if(screwUp):
            print('You managed to screw this one up. Good Job! Please try again')
        else:
            another = input('Would you like to buy another ticket (y or n): ')
    calcPrice(moneySpent, budget)

def calcPrice(moneySpent, budget):
    realPrice = (moneySpent*.05) + moneySpent
    if(realPrice > budget):
        print('You spent '+ str((realPrice - budget)) +' more than your budget')
    elif(realPrice < budget):
        print('You spent '+ str((budget- realPrice)) +' less than your budget')
    else:
        print('You broke even')

print('Welcome to this ski resort!')
budget = int(input('Enter your budget for the day: '))
getTickets(budget, moneySpent)
             
             
