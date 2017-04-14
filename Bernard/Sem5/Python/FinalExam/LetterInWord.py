import random
import string

alphabet = string.ascii_letters
letter = alphabet[random.randint(0, len(alphabet))]
print("No reason to look at this letter -------> " + letter)
word = ""
notCorrect = True

def is_letter_in_word():
    global notCorrect
    while(notCorrect):
        word = input("Enter a word: ")
        for i in range(0, len(word), 1):
            if(word[i] == letter):
                notCorrect = False

        if(notCorrect == True):
            print("Your word does not contain the letter, try again.")
        else:
            print("The word you entered contained the letter, it was " + letter)

is_letter_in_word()
            
                      
