def factors_of(n):
    factors = []
    for prime in [2]:
        while n % prime == 0:
            factors.append(prime)
            n //= prime

    if n > 1:
        factors.append(n)

    return factors


def primes_up_to(limit):
    if limit > 1:
        yield 2
