class Game:
    def __init__(self):
        self.points = 0

    def roll(self, pins: int):
        self.points += pins

    def score(self):
        return self.points
