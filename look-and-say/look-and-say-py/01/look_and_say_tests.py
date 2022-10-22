import unittest
from sequence import look_and_say


class LookAndSayTestCase(unittest.TestCase):
    def test_look_and_say(self):
        self.assertEqual("11", look_and_say("1"))


if __name__ == '__main__':
    unittest.main()
