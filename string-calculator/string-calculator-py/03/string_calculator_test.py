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
        ['-1,2\n3', '-1'],
        ['-1,-2\n-3,4,5', '-1,-2,-3']
    ])
    def test_add_negatives_numbers_should_raise_error_with_those_numbers_in_message(
            self,
            numbers: str,
            ex_message: str):
        with self.assertRaises(NegativesNotAllowedError) as error:
            self.calculator.add(numbers)

        self.assertTrue(ex_message in str(error.exception))

    @parameterized.expand([
        ['//;\n1;1\n0', 2],
        ['//[;]\n1;2\n3', 6],
        ['//[++]\n1,2\n2++3', 8],
    ])
    def test_add_multiple_numbers_separated_by_custom_delimiter_should_return_sum_of_that_numbers(
            self,
            numbers: str,
            expected_sum: int):
        self.assertEqual(expected_sum, self.calculator.add(numbers))

    @parameterized.expand([
        ['//[^][_*_]\n1,2_*_3^4\n5', 15],
        ['//[_][_"_]\n1,2_"_3_4\n5', 15],
    ])
    def test_add_multiple_numbers_separated_by_multiple_custom_delimiter_should_return_sum_of_that_numbers(
            self,
            numbers: str,
            expected_sum: int):
        self.assertEqual(expected_sum, self.calculator.add(numbers))


if __name__ == '__main__':
    unittest.main()
