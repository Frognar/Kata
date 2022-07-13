def factors_of(n):
    factors = []
    while n % 2 == 0:
        factors.append(2)
        n //= 2

    if n > 1:
        factors.append(n)
    return factors
