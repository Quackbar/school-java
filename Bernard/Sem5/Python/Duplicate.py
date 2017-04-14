alpha = 'abcdefghijklmnopqrstuvwxyz '
alphaNum = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]


def remove_dups(string):
    final = ''
    for i in range(len(string)):
        for n in range(len(alpha)):
            if(string[i].lower() == alpha[n]):
                if(alphaNum[n] == 0):
                    alphaNum[n] = 1
                    final += alpha[n]
                    
                
    return final

string = input('Enter your String: ')
finalS = remove_dups(string)

print(finalS)
