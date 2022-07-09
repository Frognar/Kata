def factors_of(n):
    factors = []
    for prime in range(2, n + 1):
        while n % prime == 0:
            factors.append(prime)
            n /= prime

    return factors
