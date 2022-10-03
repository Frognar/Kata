import unittest
from parameterized import parameterized
from string_calculator import StringCalculator, NegativesNotAllowedError


class StringCalculatorTestCase(unittest.TestCase):
    def setUp(self) -> None:
        self.calculator = StringCalculator()

    def test_add_none_should_return_zero(self):
        self.assertEqual(0, self.calculator.add(None))

    def test_add_empty_should_return_zero(self):
        self.assertEqual(0, self.calculator.add(''))

    @parameterized.expand([
        ['1', 1],
        ['2', 2],
    ])
    def test_add_single_number_should_return_this_number(self, numbers: str, expected_sum: int):
        self.assertEqual(expected_sum, self.calculator.add(numbers))

    @parameterized.expand([
        ['1,9', 10],
        ['1,1\n9', 11]
    ])
    def test_add_multiple_numbers_separated_by_default_delimiter_should_return_sum_of_that_numbers(
            self,
            numbers: str,
            expected_sum: int):
        self.assertEqual(expected_sum, self.calculator.add(numbers))

    @parameterized.expand([
        ['-1,2\n3', '-1']
    ])
    def test_add_negatives_numbers_should_raise_error_with_those_numbers_in_message(
            self,
            numbers: str,
            ex_message: str):
        with self.assertRaises(NegativesNotAllowedError) as error:
            self.calculator.add(numbers)

        self.assertTrue(ex_message in str(error.exception))


if __name__ == '__main__':
    unittest.main()
