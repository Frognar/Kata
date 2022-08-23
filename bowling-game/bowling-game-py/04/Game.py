class Game:
    def __init__(self):
        self.points = 0

    def roll(self, pins) -> None:
        self.points += pins

    def score(self) -> int:
        return self.points
