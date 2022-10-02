import unittest
from string_calculator import StringCalculator


class StringCalculatorTestCase(unittest.TestCase):
    def test_add_none_should_return_zero(self):
        calculator = StringCalculator()
        self.assertEqual(0, calculator.add(None))

    def test_add_empty_should_return_zero(self):
        calculator = StringCalculator()
        self.assertEqual(0, calculator.add(''))

    def test_add_one_number_in_string_should_return_this_number(self):
        calculator = StringCalculator()
        self.assertEqual(4, calculator.add('4'))


if __name__ == '__main__':
    unittest.main()
