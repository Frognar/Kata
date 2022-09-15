import unittest
from NameInverter import NameInverter


class NameInverterTestCase(unittest.TestCase):
    def test_invert_none_should_raise_error(self):
        self.assertRaises(AttributeError, NameInverter.invert, None)

    def test_invert_empty_should_return_empty(self):
        self.assertEqual('', NameInverter.invert(''))

    def test_invert_whitespaces_should_return_empty(self):
        self.assertEqual('', NameInverter.invert('   '))

    def test_invert_firstname_should_return_firstname(self):
        self.assertEqual('Horus', NameInverter.invert('Horus'))

    def _test_invert_first_last_should_return_last_comma_first(self):
        self.assertEqual('Horus Lupercal', NameInverter.invert('Lupercal, Horus'))


if __name__ == '__main__':
    unittest.main()
