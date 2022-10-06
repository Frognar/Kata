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
        ['11', 11],
        ['121', 121],
        ['12,21', 33],
        ['12,21\n3', 36],
        ['//p\n12,21\n3p3', 39],
        ['//[p]\n12,21\n3p3', 39],
        ['//[ppp]\n12,21\n3ppp3', 39],
        ['//[f][ppp]\n12,21\n3ppp3f9', 48],
        ['//[p][ppp]\n12,21\n3ppp3p9', 48],
    ])
    def test_add_should_return_sum_of_given_numbers(self, numbers: str, expected_sum: int):
        self.assertEqual(expected_sum, self.calculator.add(numbers))

    @parameterized.expand([
        ['//[p][ppp]\n12,-21\n3ppp3p9', '-21'],
        ['//[p][ppp]\n12,-21\n3ppp-3p-9', '-21,-3,-9'],
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
