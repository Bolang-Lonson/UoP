# Write program to display your name and perform following operations on it: 
# Display n characters from left. (Accept n as input from the user)
# Count the number of vowels. 
# Reverse it.

def display_left(name, n):
    # checking if n is a number
    if not isinstance(n, int):
        raise TypeError('n must be an integer')
    else:
        # printing sliced substring
        print(name[:n])


def vowel_count(name):
    vowels = 'aeiou'    # Listing out the vowels
    count = 0   # Initialising count variable
    for ch in name:
        if ch in vowels:    # Checking if the character is a vowel
            count += 1

    return count


def reverse(name):
    # creating empty string to concatenate letters in the future
    inverse = ''
    for ch in name:
        # looping through and adding each letter to the front
        inverse = ch + inverse

    return inverse


print(reverse('Saadiq'))
display_left('Lonson', 3)
print(vowel_count('Bolang-Lonson'))