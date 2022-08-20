import unittest
from Game import Game


class MyTestCase(unittest.TestCase):
    def setUp(self) -> None:
        self.game = Game()

    def roll_many(self, n, pins):
        [self.game.roll(pins) for _ in range(n)]

    def test_all_zeros(self):
        self.roll_many(20, 0)
        assert 0 == self.game.score()

    def test_all_ones(self):
        self.roll_many(20, 1)
        assert 20 == self.game.score()

    def test_one_spare(self):
        self.game.roll(5)
        self.game.roll(5)
        self.game.roll(3)
        self.roll_many(17, 0)
        assert 16 == self.game.score()

if __name__ == '__main__':
    unittest.main()
