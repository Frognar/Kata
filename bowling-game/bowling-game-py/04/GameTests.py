import unittest
from Game import Game


class BowlingGameTestCase(unittest.TestCase):
    def setUp(self):
        self.game = Game()

    def test_all_zeros(self):
        [self.game.roll(0) for _ in range(20)]
        assert 0 == self.game.score()


if __name__ == '__main__':
    unittest.main()
