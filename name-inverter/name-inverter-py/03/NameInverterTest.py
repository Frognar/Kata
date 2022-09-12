import unittest
from NameInverter import NameInverter


class NameInverterTestTestCase(unittest.TestCase):
    def test_invert_none_should_raise_error(self):
        self.assertRaises(AttributeError, NameInverter.invert, None)

    def test_invert_empty_should_return_empty(self):
        self.assertEqual(NameInverter.invert(''), '')

    def test_invert_whitespaces_should_return_empty(self):
        self.assertEqual(NameInverter.invert('    '), '')

    def test_invert_first_should_return_first(self):
        self.assertEqual(NameInverter.invert('Horus'), 'Horus')


if __name__ == '__main__':
    unittest.main()
