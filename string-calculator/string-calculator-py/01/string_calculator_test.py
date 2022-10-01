import unittest
from string_calculator import StringCalculator, NegativesNotAllowedError
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
        ['2,4', 6],
        ['2,4,8', 14],
        ['2,4\n8', 14]
    ])
    def test_add_multiple_numbers_separated_by_default_delimiter_should_return_sum_of_that_numbers(self, numbers: str, expected_sum: int):
        self.assertEqual(expected_sum, self.calculator.add(numbers))

    @parameterized.expand([
        ['2,-1', '-1'],
        ['2,-1,-4', '-1,-4']
    ])
    def test_add_some_negatives_numbers_should_raise_error_with_those_numbers_in_message(self, numbers: str, ex_message: str):
        with self.assertRaises(NegativesNotAllowedError) as error:
            self.calculator.add(numbers)

        self.assertTrue(ex_message in str(error.exception))

    @parameterized.expand([
        ['//;\n5;2;6', 13],
        ['//*\n5*2*6', 13],
        ['//[*]\n5*2*6', 13],
        ['//[*+]\n5*+2*+6', 13]
    ])
    def test_add_multiple_numbers_separated_by_custom_delimiter_should_return_sum_of_that_numbers(self, numbers: str, expected_sum: int):
        self.assertEqual(expected_sum, self.calculator.add(numbers))

    @parameterized.expand([
        ['//[+][*]\n1,2+3*4', 10],
        ['//[+][++]\n1,2+3++4', 10]
    ])
    def test_add_multiple_numbers_separated_by_multiple_custom_delimiter_should_return_sum_of_that_numbers(self, numbers: str, expected_sum: int):
        self.assertEqual(expected_sum, self.calculator.add(numbers))


if __name__ == '__main__':
    unittest.main()
