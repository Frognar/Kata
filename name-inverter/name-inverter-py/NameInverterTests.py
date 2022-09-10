import unittest

from NameInverter import invert


class NameInverterTestCase(unittest.TestCase):
    def test_invert_none_should_throw_exception(self):
        self.assertRaises(TypeError, invert, None)

    def test_invert_empty_should_return_empty(self):
        self.assertEqual(invert(''), '')


if __name__ == '__main__':
    unittest.main()
