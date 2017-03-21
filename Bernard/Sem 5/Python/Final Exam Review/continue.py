ans = ""
while(True):
    ans = input('Do you want to continue (y/n/Yes/No): ')
    if(ans.lower() == 'no' or ans.lower() == 'n'):
        print('Thats all folks!')
        break
