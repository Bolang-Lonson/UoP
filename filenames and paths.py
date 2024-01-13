import os

cwd = os.getcwd() + '/'
file = cwd + 'filenames and paths.py'
print(cwd)

print(os.path.exists(file))
print(os.path.isdir(cwd))
print(os.path.isdir(file))    #   checks whether it is a directory if it exists

# checking if it is a file 
print(os.path.isfile(file)) #   True
print(os.path.isfile(cwd))  #   False

#   Listing files and directories in a path
print(os.listdir(cwd))  #   returns a list of strings of all files and subdirs

for item in os.listdir(cwd):
    if item.endswith('.py'):
        # printing all py files
        print(item)


import os
def scan(dirname):
    for name in os.listdir(dirname):
        path = os.path.join(dirname, name)

        if os.path.isfile(path):
            print(path)
        else:
            scan(path)

os.chdir('/Users/annie')
scan('Downloads')