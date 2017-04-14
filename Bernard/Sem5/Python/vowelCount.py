#Bernard Kintzing
#Vowel count

word = input('Enter yo Word brutha bear: ')
vowel = ["a","e","i","o","u"]
vowelCount = 0 

for i in range(len(word)):
    if(word[i].lower() in vowel):
        vowelCount = vowelCount + 1

print(word + ' has ' + str(vowelCount) + ' vowels')
        
