import unittest
from parameterized import parameterized
from sequence import look_and_say, look_and_say_sequence


class LookAndSayTestCase(unittest.TestCase):
    @parameterized.expand([
        ('2', '12'),
        ('12', '1112'),
        ('22', '22'),
        ('1211', '111221'),
        ('111221', '312211'),
    ])
    def test_look_and_say(self, current: str, expected: str):
        self.assertEqual(expected, look_and_say(current))

    @parameterized.expand([
        ('5', 0, '5'),
        ('5', 1, '5 15'),
        ('5', 2, '5 15 1115'),
        ('5', 5, '5 15 1115 3115 132115 1113122115'),
    ])
    def test_look_and_say_sequence(self, start: str, depth: int, expected: str):
        self.assertEqual(expected, look_and_say_sequence(start, depth))


if __name__ == '__main__':
    unittest.main()
