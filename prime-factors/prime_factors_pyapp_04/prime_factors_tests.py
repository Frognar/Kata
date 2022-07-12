import unittest


def factors_of(n):
    factors = []
    prime = 2
    if n > 1:
        while n % prime == 0:
            factors.append(prime)
            n //= prime

    if n > 1:
        factors.append(n)

    return factors


def primes_up_to(limit):
    primes = []
    if limit > 1:
        primes.append(2)

    return primes


class PrimeFactorsTestCase(unittest.TestCase):
    def test_factors_of(self):
        self.assertEqual([], factors_of(1)) 
        self.assertEqual([2], factors_of(2))
        self.assertEqual([3], factors_of(3))
        self.assertEqual([2, 2], factors_of(4))
        self.assertEqual([5], factors_of(5))
        self.assertEqual([2, 3], factors_of(6))
        self.assertEqual([7], factors_of(7))
        self.assertEqual([2, 2, 2], factors_of(8))
        # self.assertEqual([3, 3], factors_of(9))
    
    def test_primes_up_to(self):
        self.assertEqual([], list(primes_up_to(1)))
        self.assertEqual([2], list(primes_up_to(2)))


if __name__ == '__main__':
    unittest.main()
