import unittest


def factors_of(n):
    return []


class FactorsOfTestCase(unittest.TestCase):
    def test_factors_of(self):
        self.assertEqual([], factors_of(1))


if __name__ == '__main__':
    unittest.main()
