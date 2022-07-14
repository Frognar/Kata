def factors_of(n):
    factors = []
    primes = [2]
    for prime in primes:
        while n % prime == 0:
            factors.append(prime)
            n //= prime

    if n > 1:
        factors.append(n)
    return factors


def primes_up_to(limit):
    primes = [True for _ in range(limit + 1)]
    for candidate in range(2, limit + 1):
        if primes[candidate]:
            for multiply in range(2 * candidate, limit + 1, candidate):
                primes[multiply] = False
            yield candidate
