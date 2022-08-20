class Game:
    def __init__(self):
        self.rolls = []
        self.current_roll = 0

    def roll(self, pins: int):
        self.rolls.append(pins)
        self.current_roll += 1

    def score(self) -> int:
        score = 0
        first_in_frame = 0
        for i in range(10):
            if self.two_balls_in_frame(first_in_frame) == 10:
                score += 10 + self.rolls[first_in_frame + 2]
                first_in_frame += 2
            else:
                score += self.two_balls_in_frame(first_in_frame)
                first_in_frame += 2
        return score

    def two_balls_in_frame(self, first_in_frame) -> int:
        return self.rolls[first_in_frame] + self.rolls[first_in_frame + 1]
