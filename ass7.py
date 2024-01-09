'''Programming Assignment Unit 8'''

def invert_dict(d):
    ''' Since there might be several letters with the same
frequency, each value in the inverted dictionary should be a list of letters.'''
    inverse = {}
    for k in d:
        val = d[k]
        for attr in val:
            if attr in inverse:
                inverse[attr] += (k,)
            else:
                inverse[attr] = (k,)

    return inverse


def dictWrite(d):
    '''writes the dictionary to a file in readable json-like format'''
    string = ''
    for key, value in d.items():
        val = f'{value}'.strip('()')
        string += f'{key}: {val}\n'

    return '{\n' + string + '}'


with open('mydict.txt', 'r') as dic:
    data = dic.read().strip('{}').strip()
    lines = data.split('\n')
    newDict = {}

    for val in lines:
        '''reading content and writing to a dictionary'''
        pair = val.split(':')
        newDict[pair[0]] = tuple(pair[1].strip().split(','))

    with open('mydict_inverted.txt', 'w') as inv:
        inv.write(dictWrite(newDict))