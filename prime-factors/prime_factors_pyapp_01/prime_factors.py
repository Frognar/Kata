def factors_of(n):
    factors = []
    for prime in primes_up_to(n):
        while n % prime == 0:
            factors.append(prime)
            n /= prime

    return factors


def primes_up_to(n):
    return range(2, n + 1)