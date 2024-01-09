'''A format sequence can appear anywhere in the string, so you can embed a value in a
sentence'''
camels = 5
print('I have spotted %d camels.' %camels)

'''If there is more than one format sequence in the string, the second argument has to be a
tuple. Each format sequence is matched with an element of the tuple, in order.'''
print('In %d years I\'ve spotted %g %s' %(3, 0.1, 'camels'))