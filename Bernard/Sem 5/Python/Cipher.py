#Bernard Kintzing
#Cipher Program

while(True):
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    passwordCheck = 'SamSucks'
    method = ''
    while(method != 'encoding' and method != 'decoding'):
        method = input('Are you encoding or decoding: ')
    thing = input('Are you using your own personal key (y or n) ')
    if(thing == 'y'):
        alphabet = input('Enter your personal key')

    def encode(word, alphabet):
        encryptedWord = ''
        for i in range(len(word)):
            for n in range(len(alphabet)):
                if(word[i].lower() == alphabet[n]):
                    encryptedWord = encryptedWord + alphabet[(n+15)%len(alphabet)]

        return encryptedWord
            

    def decode(word, alphabet, passwordCheck):
        password = ''
        decryptedWord = ''
        while(password != passwordCheck):
            password = input('Enter the password: ')

        for i in range(len(word)):
            for n in range(len(alphabet)):
                if(word[i].lower() == alphabet[n]):
                    decryptedWord = decryptedWord + alphabet[(n-15)%len(alphabet)]

        return decryptedWord

    if(method == 'encoding'):
        word = input('Enter the word you wish to encrypt: ')
        encryptedWord = encode(word, alphabet)
        print(encryptedWord)
    else:
        word = input('Enter the word you wish to decrypt: ')
        decryptedWord = decode(word, alphabet, passwordCheck)
        print(decryptedWord)
    
    
