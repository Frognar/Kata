import unittest
from NameInverter import NameInverter


class NameInverterTestCase(unittest.TestCase):
    def test_invert_none_should_raise_attribute_error(self):
        self.assertRaises(AttributeError, NameInverter.invert, None)

    def test_invert_empty_should_return_empty(self):
        self.assertEqual(NameInverter.invert(''), '')

    def test_invert_whitespaces_should_return_empty(self):
        self.assertEqual(NameInverter.invert('   '), '')

    def test_invert_first_should_return_first(self):
        self.assertEqual(NameInverter.invert('Horus'), 'Horus')

    def test_invert_first_last_should_return_last_comma_first(self):
        self.assertEqual(NameInverter.invert('Horus Lupercal'), 'Lupercal, Horus')

    def test_invert_first_whitespaces_last_should_return_last_comma_first(self):
        self.assertEqual(NameInverter.invert('Horus    Lupercal'), 'Lupercal, Horus')

    def test_invert_honorific_first_last_should_return_last_comma_first(self):
        self.assertEqual(NameInverter.invert('Mr. Horus Lupercal'), 'Lupercal, Horus')
        self.assertEqual(NameInverter.invert('Mrs. Horus Lupercal'), 'Lupercal, Horus')


if __name__ == '__main__':
    unittest.main()
