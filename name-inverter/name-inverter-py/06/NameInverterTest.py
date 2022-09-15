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

    def test_invert_first_last_should_return_last_comma_first(self):
        self.assertEqual('Lupercal, Horus', NameInverter.invert('Horus Lupercal'))

    def test_invert_first_whitespaces_last_should_return_last_comma_first(self):
        self.assertEqual('Lupercal, Horus', NameInverter.invert('Horus   Lupercal'))

    def test_invert_honorific_first_last_should_return_last_comma_first(self):
        self.assertEqual('Lupercal, Horus', NameInverter.invert('Mr. Horus Lupercal'))
        self.assertEqual('Lupercal, Horus', NameInverter.invert('Mrs. Horus Lupercal'))

    def test_invert_first_last_postnominal_should_return_last_comma_first_postnominal(self):
        self.assertEqual('Lupercal, Horus Sr.', NameInverter.invert('Horus Lupercal Sr.'))

    def test_invert_first_last_postnominals_should_return_last_comma_first_postnominals(self):
        self.assertEqual('Lupercal, Horus Sr. PhD.', NameInverter.invert('Horus Lupercal Sr. PhD.'))

    def test_invert_final(self):
        self.assertEqual('Lupercal, Horus Sr. PhD.', NameInverter.invert(' Mr.  Horus   Lupercal  Sr.  PhD. '))


if __name__ == '__main__':
    unittest.main()
