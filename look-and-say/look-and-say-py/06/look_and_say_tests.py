import unittest
from parameterized import parameterized
from sequence import look_and_say


class LookAndSayTestCase(unittest.TestCase):
    @parameterized.expand([
        ('2', '12'),
    ])
    def test_look_and_say(self, current: str, expected: str):
        self.assertEqual(expected, look_and_say(current))


if __name__ == '__main__':
    unittest.main()
