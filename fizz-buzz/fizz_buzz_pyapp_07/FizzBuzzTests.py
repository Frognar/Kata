import unittest

from FizzBuzz import fizz_buzz


class FizzBuzzTestCase(unittest.TestCase):
    def test_fizz_buzz(self):
        self.assertEqual("1", fizz_buzz(1))
        self.assertEqual("2", fizz_buzz(2))
        self.assertEqual("Fizz", fizz_buzz(3))
        self.assertEqual("4", fizz_buzz(4))
        self.assertEqual("Buzz", fizz_buzz(5))
        self.assertEqual("Fizz", fizz_buzz(6))
        self.assertEqual("7", fizz_buzz(7))
        self.assertEqual("8", fizz_buzz(8))
        self.assertEqual("Fizz", fizz_buzz(9))
        self.assertEqual("Buzz", fizz_buzz(10))
        self.assertEqual("11", fizz_buzz(11))
        self.assertEqual("Fizz", fizz_buzz(12))
        self.assertEqual("13", fizz_buzz(13))


if __name__ == '__main__':
    unittest.main()
