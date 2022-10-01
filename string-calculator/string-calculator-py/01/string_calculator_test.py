import unittest
from string_calculator import StringCalculator
from parameterized import parameterized


class StringCalculatorTestCase(unittest.TestCase):
    def setUp(self) -> None:
        self.calculator = StringCalculator()

    def test_add_none_should_return_zero(self):
        self.assertEqual(0, self.calculator.add(None))

    def test_add_empty_should_return_zero(self):
        self.assertEqual(0, self.calculator.add(''))

    @parameterized.expand([
        ['2', 2],
        ['4', 4],
    ])
    def test_add_one_number_in_string_should_return_this_number(self, numbers: str, expected_sum: int):
        self.assertEqual(expected_sum, self.calculator.add(numbers))

    @parameterized.expand([
        ['2,4', 6]
    ])
    def test_add_multiple_numbers_separated_by_comma_should_return_sum_of_that_numbers(self, numbers: str, expected_sum: int):
        self.assertEqual(expected_sum, self.calculator.add(numbers))


if __name__ == '__main__':
    unittest.main()
