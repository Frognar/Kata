import unittest

from prime_factors import *


class PrimeFactorsTestCase(unittest.TestCase):
    def test_factors_of(self):
        self.assertEqual([], factors_of(1))
        self.assertEqual([2], factors_of(2))
        self.assertEqual([3], factors_of(3))
        self.assertEqual([2, 2], factors_of(4))


if __name__ == '__main__':
    unittest.main()
