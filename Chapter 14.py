# fin = open('words.txt') #   creates an object

# print(fin.readline())
# # printing first ten lines from text file
# for i in range(11):
#     print(fin.readline())


# reading and printing every line in fin object
# for line in fin:
#     print(line.strip())


# writing to text files
fout = open('testfile.txt', 'w')
'''If the file already exists, opening it in write mode clears out the old data and starts fresh,
so be careful! If the file doesn’t exist, a new one is created.'''

line = 'The quick brown fox jumped over the lazy dog\n'
fout.write(line)
'''The argument of write() has to be a string, so if we want to put other values in a file, we
have to convert them to strings'''
x = 53
fout.write(str(x))
# using the format operator %
camels = 42
fout.write('\n%d' % camels)
fout.close()