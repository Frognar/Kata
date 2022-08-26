class Game:
    def __init__(self):
        self.rolls = []

    def roll(self, pins) -> None:
        self.rolls.append(pins)

    def score(self) -> int:
        score = 0
        for i in range(len(self.rolls)):
            score += self.rolls[i]
        return score
