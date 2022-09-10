import unittest

from NameInverter import invert


class NameInverterTestCase(unittest.TestCase):
    def test_invert_none_should_throw_exception(self):
        self.assertRaises(AttributeError, invert, None)

    def test_invert_empty_should_return_empty(self):
        self.assertEqual(invert(''), '')

    def test_invert_whitespaces_should_return_empty(self):
        self.assertEqual(invert('    '), '')

    def test_invert_first_should_return_first(self):
        self.assertEqual(invert('Horus'), 'Horus')

    def test_invert_first_last_should_return_last_comma_first(self):
        self.assertEqual(invert('Horus Lupercal'), 'Lupercal, Horus')

    def test_invert_first_whitespaces_last_should_return_last_comma_first(self):
        self.assertEqual(invert('Horus    Lupercal'), 'Lupercal, Horus')

    def test_invert_honorific_first_last_should_return_last_comma_first(self):
        self.assertEqual(invert('Mr. Horus Lupercal'), 'Lupercal, Horus')
        self.assertEqual(invert('Mrs. Horus Lupercal'), 'Lupercal, Horus')

    def test_invert_first_last_postnominal_should_return_last_comma_first_postnominal(self):
        self.assertEqual(invert('Horus Lupercal Sr.'), 'Lupercal, Horus Sr.')

    def test_invert_first_last_postnominals_should_return_last_comma_first_postnominals(self):
        self.assertEqual(invert('Horus Lupercal Sr. PhD.'), 'Lupercal, Horus Sr. PhD.')


if __name__ == '__main__':
    unittest.main()
