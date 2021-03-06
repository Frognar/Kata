import unittest

from prime_factors import factors_of


class FactorOfTestCase(unittest.TestCase):
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
        #self.assertEqual([2**61-1], factors_of(2**61-1))


if __name__ == '__main__':
    unittest.main()
