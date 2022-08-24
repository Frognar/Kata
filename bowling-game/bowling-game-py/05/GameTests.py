import unittest
from Game import Game


class BowlingGameTestCase(unittest.TestCase):
    def setUp(self):
        self.game = Game()

    def roll_many(self, n, pins):
        [self.game.roll(pins) for _ in range(n)]

    def roll_spare(self):
        self.roll_many(2, 5)

    def roll_strike(self):
        self.game.roll(10)

    def test_all_zeros(self):
        self.roll_many(20, 0)
        assert 0 == self.game.score()

    def test_all_ones(self):
        self.roll_many(20, 1)
        assert 20 == self.game.score()

    def test_spare(self):
        self.roll_spare()
        self.game.roll(8)
        self.roll_many(17, 0)
        assert 26 == self.game.score()

    def test_strike(self):
        self.roll_strike()
        self.game.roll(8)
        self.game.roll(1)
        self.roll_many(16, 0)
        assert 28 == self.game.score()


if __name__ == '__main__':
    unittest.main()
