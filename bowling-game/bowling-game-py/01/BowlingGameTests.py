import unittest
from Game import Game


class MyTestCase(unittest.TestCase):
    def setUp(self) -> None:
        self.game = Game()

    def test_can_roll(self):
        self.game.roll(0)

    def test_all_zeros(self):
        [self.game.roll(0) for _ in range(20)]
        assert 0 == self.game.score()


if __name__ == '__main__':
    unittest.main()
