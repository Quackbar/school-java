def reverse(string, reverseS, i):
    length = len(string)
    reverseS += string[length-i]
    i = i+1;
    if(i <= length):
        reverse(string, reverseS, i)
    else:
        print(reverseS)

string = input('Enter a String: ')
i = 1
reverseS = ''
reverse(string, reverseS, i)


