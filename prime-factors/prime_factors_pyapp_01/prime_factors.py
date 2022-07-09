import math


def factors_of(n):
    factors = []
    limit = int(math.sqrt(n))
    for prime in primes_up_to(limit):
        while n % prime == 0:
            factors.append(prime)
            n /= prime

    if n > 1:
        factors.append(n)

    return factors


def primes_up_to(n):
    composites = [False for _ in range(n + 1)]
    primes = []
    for candidate in range(2, n + 1):
        if not composites[candidate]:
            primes.append(candidate)
            for multiply in range(2 * candidate, n + 1, candidate):
                composites[multiply] = True
    return primes
