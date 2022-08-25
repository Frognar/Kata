import unittest
from Game import Game


class BowlingGameTestCase(unittest.TestCase):
    def test_can_create_game(self):
        game = Game()


if __name__ == '__main__':
    unittest.main()
