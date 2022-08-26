class Game:
    def __init__(self):
        self.rolls = []

    def roll(self, pins) -> None:
        self.rolls.append(pins)

    def score(self) -> int:
        score = 0
        first_in_frame = 0
        for frame in range(10):
            if self.is_spare(first_in_frame):
                score += 10 + self.rolls[first_in_frame + 2]
                first_in_frame += 2
            else:
                score += self.two_balls_in_frame(first_in_frame)
                first_in_frame += 2
        return score

    def is_spare(self, first_in_frame) -> bool:
        return self.two_balls_in_frame(first_in_frame) == 10

    def two_balls_in_frame(self, first_in_frame) -> int:
        return self.rolls[first_in_frame] + self.rolls[first_in_frame + 1]