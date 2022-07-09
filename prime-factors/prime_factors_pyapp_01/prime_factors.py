def factors_of(n):
    factors = []
    if n > 1:
        prime = 2
        while n % prime == 0:
            factors.append(prime)
            n /= prime

    if n > 1:
        factors.append(n)
    return factors
