import unittest
from Game import Game


class MyTestCase(unittest.TestCase):
    def test_can_create_game(self):
        game = Game()

    def test_can_roll(self):
        game = Game()
        game.roll(0)


if __name__ == '__main__':
    unittest.main()
