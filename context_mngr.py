with open('words.txt', 'r') as file:
    '''allow us to work with files from only within this block'''
    chars = 100
    content = file.read(chars)
    print(content)

    file.seek(0)    #   resets our position to beginning of the file

    content = file.read(chars)
    print(content)
    # for line in file:
    #     print(line, end='')
    # while len(content) > 0:
    #     print(content, end='*')
    #     content = file.read(chars)


with open('write.txt', 'w') as file:
    file.write('Test')
    file.seek(0)    #   sets writing head to position 0
    file.write('R') #   replaces character at 0 to 'R'

'''copying from one file to another'''
with open('testfile.txt', 'r') as rf:
    with open('testcopy.txt', 'w') as wf:
        for line in rf:
            wf.write(line)