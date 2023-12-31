employees = ['Alice Johnson',
'Bob Smith',
'Charlie Brown',
'Diana Garcia',
'Evelyn Miller',
'Frank Jones',
'Grace Lee',
'Harry Williams',
'Irene Lopez',
'John Davis']

salaryList = [52300, 68850, 39900, 44250, 75100, 57600, 48450, 32700, 54900, 61050]

size = len(employees)
subList1 = employees[:(size//2)]
subList2 = employees[(size//2):]
# adding new employee to sublist2
subList2.append('Kriti Brown')
# Remove the second employee's name from subList1.
del subList1[1]
# Merge both the lists.
subList1.extend(subList2)
print(subList1)
# Give a rise of 4% to every employee and update the salaryList.

for i in range(len(salaryList)):
    salaryList[i] *= 1.04

# Sort the SalaryList and show top 3 salaries.
salaryList.sort(reverse=True)
print(salaryList[:3])

# Part B
'''Design a program such that it converts a sentence into wordlist. Reverse the wordlist then.'''
sentence = 'The quick brown fox jumped over the lazy dog'

# converting into wordlist using split() method
wordList = sentence.split(' ')
# separating with an empty space as words in english are also separated by empty spaces when used in a sentence.
print(wordList)
# reversing wordlist with the reverse() method
wordList.reverse()
print(wordList)