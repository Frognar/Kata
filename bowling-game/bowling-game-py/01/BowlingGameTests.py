import unittest
from Game import Game


class MyTestCase(unittest.TestCase):
    def setUp(self) -> None:
        self.game = Game()

    def test_can_roll(self):
        self.game.roll(0)


if __name__ == '__main__':
    unittest.main()
