from math import sqrt


def factors_of(n):
    factors = []
    for prime in primes_up_to(int(sqrt(n))):
        while n % prime == 0:
            factors.append(prime)
            n //= prime

    if n > 1:
        factors.append(n)

    return factors


def primes_up_to(limit):
    composites = [False for _ in range(limit + 1)]
    primes = []
    for candidate in range(2, limit + 1):
        if not composites[candidate]:
            for multiply in range(2 * candidate, limit + 1, candidate):
                composites[multiply] = True
            primes.append(candidate)
    return primes

