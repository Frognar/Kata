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
    return range(2, n + 1)