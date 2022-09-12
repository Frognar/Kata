import unittest
from NameInverter import NameInverter


class NameInverterTestTestCase(unittest.TestCase):
    def test_invert_none_should_raise_error(self):
        self.assertRaises(AttributeError, NameInverter.invert, None)


if __name__ == '__main__':
    unittest.main()
