# def count(n):
#     while n > 0:
#         print(n)
#         n -= 1

#     print('Blast off!')

# count(17)

def sqrt(a, x):
    y = (x + a/x)/2
    if y == x:
        print(y)
        return y
    else:
        sqrt(a = a, x = y)


sqrt(9, 14)