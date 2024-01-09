'''Any file that contains Python code can be imported as a module'''

def lineCount(filename):
    count = 0
    for line in open(filename):
        count += 1
    return count


if __name__ == '__main__':
    print(lineCount('writing_modules.py'))