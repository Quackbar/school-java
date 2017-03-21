#Bernard Kintzing
#Multiplication Table

row = int(input("Enter the number of rows: "))
col = int(input("Enter the number of columns: "))

for i in range(row):
    if(i == 0):
        for n in range(row):
            n = n + 1
            if(n == 1):
                print("*  |  " + str(n) + "    ", end="")
            elif(n == row):
                print(str(n))
            else:
                if(n<10):
                    print(str(n) + "    ", end="")
                else:
                    print(str(n) + "   ", end="")
                
        for n in range(row + 1):
            if(n == 0):
                print("---|", end="")
            elif(n == row):
                print("-----")
            else:
                print("-----", end="")
            n = n + 1

for c in range(col):
    c = c+1
    for r in range(row):
        r=r+1
        if(r == 1):
            if(c<10):
                print(str(c) + "  |  " + str(c*r) + "    ", end="")
            elif(c<100):
                print(str(c) + " |  " + str(c*r) + "   ", end="")
            else:
                print(str(c) + "|  " + str(c*r) + "  ", end="")
            
        elif(r == row):
                print(str(c*r))
            
        else:
            if((c*r) < 10):
                print(str(c*r) + "    ", end="")
            elif((c*r) < 100):
                print(str(c*r) + "   ", end="")
            elif((c*r) < 1000):
                print(str(c*r) + "  ", end="")
            else:
                print(str(c*r) + " ", end="")
        

        
                
                      
    
