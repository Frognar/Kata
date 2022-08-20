class Game:
    def __init__(self):
        self.rolls = []
        self.current_roll = 0

    def roll(self, pins: int):
        self.rolls.append(pins)
        self.current_roll += 1

    def score(self):
        score = 0
        first_in_frame = 0
        for i in range(10):
            score += self.rolls[first_in_frame] + self.rolls[first_in_frame + 1]
            first_in_frame += 2
        return score
