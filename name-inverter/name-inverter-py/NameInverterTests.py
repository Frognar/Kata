import unittest

from NameInverter import invert


class NameInverterTestCase(unittest.TestCase):
    def test_invert_none_should_throw_exception(self):
        self.assertRaises(TypeError, invert, None)

    def test_invert_empty_should_return_empty(self):
        self.assertEqual(invert(''), '')

    def test_invert_whitespaces_should_return_empty(self):
        self.assertEqual(invert('    '), '')

    def test_invert_first_should_return_first(self):
        self.assertEqual(invert('Horus'), 'Horus')


if __name__ == '__main__':
    unittest.main()
