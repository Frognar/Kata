import unittest
from parameterized import parameterized
from string_calculator import StringCalculator


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
    ])
    def test_add_should_return_sum_of_given_numbers(self, numbers: str, expected_sum: int):
        self.assertEqual(expected_sum, self.calculator.add(numbers))


if __name__ == '__main__':
    unittest.main()
