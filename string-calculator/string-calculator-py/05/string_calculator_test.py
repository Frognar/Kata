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
        ['1,2', 3],
        ['2\n2', 4],
        ['//;\n2;3', 5],
        ['//[;]\n2;3', 5],
        ['//[;;;]\n2;;;3', 5],
        ['//[;][+]\n2;3+4', 9],
        ['//[+][++]\n2++3+4', 9],
    ])
    def test_add_should_return_sum_of_given_numbers(self, numbers: str, expected_sum: int):
        self.assertEqual(expected_sum, self.calculator.add(numbers))


if __name__ == '__main__':
    unittest.main()
