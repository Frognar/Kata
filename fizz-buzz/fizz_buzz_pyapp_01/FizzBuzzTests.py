import unittest

from FizzBuzz import FizzBuzz


class MyTestCase(unittest.TestCase):
    def test_FizzBuzz(self):
        fizz_buzz = FizzBuzz()
        self.assertEqual("1", fizz_buzz.render(1))
        self.assertEqual("2", fizz_buzz.render(2))
        self.assertEqual("Fizz", fizz_buzz.render(3))
        self.assertEqual("4", fizz_buzz.render(4))


if __name__ == '__main__':
    unittest.main()
