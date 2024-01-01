'''Strictly speaking, a function can only return one value, but if the value is a tuple, the effect
is the same as returning multiple values.'''

quot, rem = divmod(7, 3)    #   returns a tuple of quotient and remainder

print(quot, rem)

def min_max(t):
    return min(t), max(t)


l_bound, u_bound = min_max(range(11))
print(l_bound, u_bound)

'''Gather and scatter operators'''
t = 7, 3  # a tuple
# print(divmod(t))    # raises TypeError expected 2 arguments

# scatter operator
print(divmod(*t))   #   (2, 1)

# Exercise: sumall()
def sumall(*args):
    tot = 0
    for val in args:
        tot += val

    return tot

print(sumall(2, 4, 6, 8))

s = 'abc'
t = [0, 1, 2]

for pair in zip(s, t):  #   zip returns an iterable of tuples of pairs from s and t
    print(pair)

print(dict(zip(s, t)))

'''You can use tuple assignment in a for loop to traverse a list of tuples:'''
t = list(zip(s, t))
for letter, number in t:
    print(number, letter)


def has_match(t1, t2):
    for x, y in zip(t1, t2):
        if x == y:
            return True
        
    return False


'''If you need to traverse the elements of a sequence and their indices, you can use the built-in
function enumerate()'''
for index, element in enumerate('def'):
    print(index, element)

'''You can also use the dictionary.items() method returning a sequence of key-value pair tuples
Mapping from tuple as a dictionary key'''
directory = dict()
directory['Joe', 'Smith'] = 673486640

print(directory)