# -----------------------------------------+
# Your name                                |
# Fox.py                                   |
# Last Updated: October, ??, 2016          |
# -----------------------------------------|
# Use loops to minimize repeated words and |
# phrases to these lyrics of "The Fox".    |
# -----------------------------------------+

print("Dog goes woof, cat goes meow.")
print("Bird goes tweet, and mouse goes squeak.")
print("Cow goes moo. Frog goes croak, and the elephant goes toot.")
print("Ducks say quack and fish go blub, and the seal goes", end="")
for i in range(3):
    print(" OW", end='')
print(".")
print("But there's one sound that no one knows...")

print("WHAT DOES THE FOX SAY?")

print()

for i in range(3):
    if(i == 0):
        first = 'Ring'
    else:
        first = 'Gering'
        
    print(first + " ding ding ding dingeringeding!")
    i = i +1

print("WHAT THE FOX SAY?")
print()

for i in range(3):
    print("Wa pa pa pa pa pa pow!")
    i = i + 1
