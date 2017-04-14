# -----------------------------------------+
# Bernard Kintzing                   	   |
# PascalsTriangle.py                       |  
# -----------------------------------------|
# Make a Pascals Triangel Program          |  
# -----------------------------------------+


def combination(n, k):
    ans = 0
    if(k==n or k==0):
        ans = 1
    else:
        ans = ans + combination(n-1,k-1) + combination(n-1,k)

    return ans


def pascals_triangle(rows):
    for row in range(rows):
        answer = ""
        for column in range(row + 1):
            answer = answer + str(combination(row, column)) + "\t"
        print(answer)

pascals_triangle(10)
