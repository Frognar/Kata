import unittest

from parameterized import parameterized

from string_calculator import StringCalculator


class StringCalculatorTestCase(unittest.TestCase):
    def setUp(self) -> None:
        self.calculator = StringCalculator()

    def test_add_none_should_return_zero(self):
        self.assertEqual(0, self.calculator.add(None))

    def test_add_empty_should_return_zero(self):
        self.assertEqual(0, self.calculator.add(''))

    @parameterized.expand([
        ['4', 4],
        ['3', 3]
    ])
    def test_add_one_number_in_string_should_return_this_number(self, numbers: str, expected_sum: int):
        self.assertEqual(expected_sum, self.calculator.add(numbers))

    @parameterized.expand([
        ['3,5', 8]
    ])
    def test_add_multiple_numbers_separated_by_comma_should_return_sum_of_that_numbers(self, numbers: str, expected_sum: int):
        self.assertEqual(expected_sum, self.calculator.add(numbers))


if __name__ == '__main__':
    unittest.main()
