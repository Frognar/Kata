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
        ('3', 0, '3'),
        ('3', 1, '3 13'),
        ('3', 2, '3 13 1113'),
        ('3', 5, '3 13 1113 3113 132113 1113122113'),
    ])
    def test_look_and_say_sequence(self, start: str, depth: int, expected: str):
        self.assertEqual(expected, look_and_say_sequence(start, depth))


if __name__ == '__main__':
    unittest.main()
