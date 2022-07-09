def factors_of(n):
    factors = []
    if n > 1:
        for prime in range(2, n + 1):
            while n % prime == 0:
                factors.append(prime)
                n /= prime

    if n > 1:
        factors.append(n)
    return factors
