import math

def area(radius):
    return math.pi * radius ** 2


ans = area(int(input('Enter radius\n')))
print('Your area is ', ans)

def compare(x, y):
    return 1 if x > y else 0 if x == y else -1

print(compare(int(input('x:\n')), int(input('y:\n'))))

def distance(x1, y1, x2, y2):
    dx = x2 - x1
    dy = y2 - y1
    dsq = dx**2 + dy**2
    return math.sqrt(dsq)

def circle_area(xc, yc, xp, yp):
    rad = distance(xc, yc, xp, yp)
    return area(rad)