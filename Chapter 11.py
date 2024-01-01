def histogram(s):
    '''counts the number of occurrence of each letter in the passed string'''
    d = dict()
    for c in s:
        if c not in d:
            d[c] = 1
        else:
            d[c] += 1

    return d

h = histogram('samsung')

for k in h:
    print(k, h[k])

for k in sorted(h):
    print(k, h[k])


# Reverse lookup
def reverse_lookup(d, v):
    '''Here is a function that takes a value and returns the first key that maps to that value:'''
    for k in d:
        if d[k] == v:
            return k
    
    raise LookupError('Value does not appear in dictionary')

#############################################################
'''For example, if you are given a dictionary that
maps from letters to frequencies, you might want to invert it; that is, create a dictionary
that maps from frequencies to letters.'''
def invert_dict(d):
    ''' Since there might be several letters with the same
frequency, each value in the inverted dictionary should be a list of letters.'''
    inverse = {}
    for k in d:
        val = d[k]
        if val in inverse:
            inverse[val].append(k)
        else:
            inverse[val] = [k]

    return inverse

hist = histogram('tyranosaurus')
print(invert_dict(hist))

# Memorised version of the fibonacci
known = {0:0, 1:1}

def fibonacci(n):
    if n in known:
        return known[n]

    res = fibonacci(n-1) + fibonacci(n-2)
    known[n] = res
    return res

print(fibonacci(25))

import pprint
pprint.pp(fibonacci(35))