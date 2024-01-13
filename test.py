vowels = 'aeiou'
name = 'saadiq'
count = [ch for ch in set(name) if ch in vowels]
print(len(count))

def show(*items):
    for i in items:
        print(i)


vals = 4, 3, 6, 0, 9

show(*vals)