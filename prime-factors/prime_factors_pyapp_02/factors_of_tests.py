import unittest

from prime_factors import factors_of, primes_up_to


class FactorsOfTestCase(unittest.TestCase):
    def test_factors_of(self):
        self.assertEqual([], factors_of(1))
        self.assertEqual([2], factors_of(2))
        self.assertEqual([3], factors_of(3))
        self.assertEqual([2, 2], factors_of(4))
        self.assertEqual([5], factors_of(5))
        self.assertEqual([2, 3], factors_of(6))
        self.assertEqual([7], factors_of(7))
        self.assertEqual([2, 2, 2], factors_of(8))
        self.assertEqual([3, 3], factors_of(9))
        self.assertEqual([2, 5], factors_of(10))
        self.assertEqual([11], factors_of(11))
        self.assertEqual([2, 2, 3, 5, 7, 11, 11, 11], factors_of(2*2*3*5*7*11*11*11))
        self.assertEqual([2**31-1], factors_of(2**31-1))

    def test_primes_up_to(self):
        self.assertEqual([], primes_up_to(1))
        self.assertEqual([2], primes_up_to(2))
        self.assertEqual([2, 3], primes_up_to(3))
        self.assertEqual([2, 3], primes_up_to(4))
        self.assertEqual([2, 3, 5], primes_up_to(5))
        self.assertEqual([2, 3, 5], primes_up_to(6))
        self.assertEqual([2, 3, 5, 7], primes_up_to(7))
        self.assertEqual([2, 3, 5, 7], primes_up_to(8))
        self.assertEqual([2, 3, 5, 7], primes_up_to(9))
        self.assertEqual([2, 3, 5, 7], primes_up_to(10))
        self.assertEqual([2, 3, 5, 7, 11], primes_up_to(11))
        self.assertEqual([2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                          31, 37, 41, 43, 47, 53, 59, 61, 67,
                          71, 73, 79, 83, 89, 97], primes_up_to(100))


if __name__ == '__main__':
    unittest.main()
