class Game:
    def __init__(self):
        self.rolls = []
        self.current_roll = 0

    def roll(self, pins: int):
        self.rolls.append(pins)
        self.current_roll += 1

    def score(self):
        score = 0
        for i in range(20):
            score += self.rolls[i]
        return score
