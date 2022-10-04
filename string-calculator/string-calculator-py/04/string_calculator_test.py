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
        ['1,2', 3],
        ['1\n2', 3],
        ['//;\n1;2', 3],
        ['//[;]\n1;2\n3', 6],
        ['//[;;]\n1;;2\n3', 6],
        ['//[;;][*]\n1;;2*3', 6],
        ['//[*][***]\n1***2*3', 6],
        ['//[*]\n1001*200*999\n1000', 2199],
    ])
    def test_add_should_return_sum_of_given_numbers(self, numbers: str, expected_sum: int):
        self.assertEqual(expected_sum, self.calculator.add(numbers))

    @parameterized.expand([
        ['-1,3\n4,5', '-1'],
        ['-1,-3\n4,-5', '-1,-3,-5'],
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
