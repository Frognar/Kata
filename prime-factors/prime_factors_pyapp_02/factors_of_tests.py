import unittest


def factors_of(n):
    factors = []
    if n > 1:
        factors.append(2)

    return factors


class FactorsOfTestCase(unittest.TestCase):
    def test_factors_of(self):
        self.assertEqual([], factors_of(1))
        self.assertEqual([2], factors_of(2))


if __name__ == '__main__':
    unittest.main()
