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
    if limit > 1:
        yield 2
