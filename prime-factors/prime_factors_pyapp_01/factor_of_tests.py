import unittest

from prime_factors import factors_of


class FactorOfTestCase(unittest.TestCase):
    def test_factors_of(self):
        self.assertEqual([], factors_of(1))


if __name__ == '__main__':
    unittest.main()
