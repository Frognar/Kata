import unittest
from string_calculator import StringCalculator


class StringCalculatorTestCase(unittest.TestCase):
    def test_add_empty_should_return_zero(self):
        calculator = StringCalculator()
        self.assertEqual(0, calculator.add(''))


if __name__ == '__main__':
    unittest.main()
