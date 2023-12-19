def hypotenuse(leg1: float, leg2: float) -> float:
    a = leg1 ** 2
    b = leg2 ** 2
    c = (a + b) ** 0.5
    return c

# print(hypotenuse(3, 4))
print(hypotenuse(5, 12))
print(hypotenuse(1, 1))

n = int(10.)
print(isinstance(n, float), isinstance(n * 1.0, float))