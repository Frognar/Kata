class Game:
    def __init__(self):
        self.rolls = []

    def roll(self, pins) -> None:
        self.rolls.append(pins)

    def score(self) -> int:
        score = 0
        first_in_frame = 0
        for frame in range(10):
            score += self.rolls[first_in_frame] + self.rolls[first_in_frame + 1]
            first_in_frame += 2
        return score
