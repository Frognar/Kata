import unittest
from string_calculator import StringCalculator


class StringCalculatorTestCase(unittest.TestCase):
    def setUp(self) -> None:
        self.calculator = StringCalculator()

    def test_add_none_should_return_zero(self):
        self.assertEqual(0, self.calculator.add(None))

    def test_add_empty_should_return_zero(self):
        self.assertEqual(0, self.calculator.add(''))

    def test_add_one_number_in_string_should_return_this_number(self):
        self.assertEqual(4, self.calculator.add('4'))


if __name__ == '__main__':
    unittest.main()
