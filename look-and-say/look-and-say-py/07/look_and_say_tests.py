import unittest
from parameterized import parameterized
from sequence import look_and_say, look_and_say_sequence


class LookAndSayTestCase(unittest.TestCase):
    @parameterized.expand([
        ('1', '11'),
        ('11', '21'),
        ('21', '1211'),
        ('1211', '111221'),
        ('111221', '312211'),
    ])
    def test_look_and_say(self, current: str, expected: str):
        self.assertEqual(expected, look_and_say(current))

    @parameterized.expand([
        ('9', 0, '9'),
        ('9', 1, '9:19'),
        ('9', 2, '9:19:1119'),
        ('9', 5, '9:19:1119:3119:132119:1113122119'),
    ])
    def test_look_and_say_sequence(self, start: str, depth: int, expected: str):
        self.assertEqual(expected, look_and_say_sequence(start, depth))


if __name__ == '__main__':
    unittest.main()
