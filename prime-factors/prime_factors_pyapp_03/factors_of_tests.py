import unittest


def factors_of(n):
    factors = []

    if n > 1:
        if n % 2 == 0:
            factors.append(2)
            n //= 2

    if n > 1:
        factors.append(n)
    return factors


class FactorsOfTestCase(unittest.TestCase):
    def test_factors_of(self):
        self.assertEqual([], factors_of(1))
        self.assertEqual([2], factors_of(2))
        self.assertEqual([3], factors_of(3))
        self.assertEqual([2, 2], factors_of(4))


if __name__ == '__main__':
    unittest.main()
