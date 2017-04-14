def substitutionCipher (message,cipherString):
    alphabet = cipherString.lower()
    realAlphabet = 'abcdefghijklmnopqrstuvwxyz'
    encryptedMessage = ""
    message = message.lower()
    for letter in range(len(message)):
        found = False
        for alphaLetter in range(len(realAlphabet)):
            if(message[letter] == realAlphabet[alphaLetter]):
                encryptedMessage += alphabet[alphaLetter]
                found = True

        if found == False:
                encryptedMessage += message[letter]
                                 
    return encryptedMessage
userMessage = input('Enter yo message: ')
mappingString = input('Enter thine cipher string: ')
print("The encrypted message = " + substitutionCipher(userMessage, mappingString))
