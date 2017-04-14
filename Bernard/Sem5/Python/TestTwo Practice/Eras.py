while(True):
    year = 0
    while(year <= 0):
        year = float(input('How many millions of years ago is it: '))

    if(year <= 66):
        print('Cenozic Era')
    elif((year <= 252.17) and (year > 66)):
        print('Mesozoic Era')
    else:
        print('Unknown Era')
