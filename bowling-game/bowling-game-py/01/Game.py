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
            if self.is_strike(first_in_frame):
                score += 10 + self.two_next_balls_for_strike(first_in_frame)
                first_in_frame += 1
            elif self.is_spare(first_in_frame):
                score += 10 + self.next_ball_for_spare(first_in_frame)
                first_in_frame += 2
            else:
                score += self.two_balls_in_frame(first_in_frame)
                first_in_frame += 2
        return score

    def is_strike(self, first_in_frame) -> bool:
        return self.rolls[first_in_frame] == 10

    def two_next_balls_for_strike(self, first_in_frame) -> int:
        return self.two_balls_in_frame(first_in_frame + 1)

    def is_spare(self, first_in_frame) -> bool:
        return self.two_balls_in_frame(first_in_frame) == 10

    def next_ball_for_spare(self, first_in_frame) -> int:
        return self.rolls[first_in_frame + 2]

    def two_balls_in_frame(self, first_in_frame) -> int:
        return self.rolls[first_in_frame] + self.rolls[first_in_frame + 1]
