import unittest
from parameterized import parameterized
from string_calculator import StringCalculator, NegativesNotAllowedError


class StringCalculatorTestCase(unittest.TestCase):
    def setUp(self):
        self.calculator = StringCalculator()

    def test_add_empty_should_return_zero(self):
        self.assertEqual(0, self.calculator.add(''))

    def test_add_None_should_return_zero(self):
        self.assertEqual(0, self.calculator.add(None))

    @parameterized.expand([
        ['1', 1],
        ['2', 2],
        ['3,4', 7],
        ['5,6\n7', 18],
        ['//!\n8,9!10', 27],
        ['//[_]\n11\n12_13', 36],
        ['//[:)]\n14:)15,16', 45],
        ['//[:)][:(]\n17:)18:(19', 54],
        ['//[:][::]\n20::21:22', 63],
    ])
    def test_add_should_return_sum_of_given_numbers(self, numbers: str, expected_sum: int):
        self.assertEqual(expected_sum, self.calculator.add(numbers))

    @parameterized.expand([
        ['23,-24\n25', '-24'],
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
