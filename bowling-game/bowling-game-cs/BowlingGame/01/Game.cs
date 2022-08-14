namespace BowlingGame._01;

public class Game {
    readonly int[] rolls = new int[21];
    int currentRoll;

    public void Roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int Score() {
        var score = 0;
        var firstInFrame = 0;
        for (var frame = 0; frame < 10; frame++)
            if (IsStrike(firstInFrame)) {
                score += 10 + NextTwoBallsForStrike(firstInFrame);
                firstInFrame++;
            }
            else if (IsSpare(firstInFrame)) {
                score += 10 + NextBallForSpare(firstInFrame);
                firstInFrame += 2;
            }
            else {
                score += TwoBallsInFrame(firstInFrame);
                firstInFrame += 2;
            }

        return score;
    }

    int NextTwoBallsForStrike(int firstInFrame) {
        return rolls[firstInFrame + 1] + rolls[firstInFrame + 2];
    }

    int NextBallForSpare(int firstInFrame) {
        return rolls[firstInFrame + 2];
    }

    int TwoBallsInFrame(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1];
    }

    bool IsStrike(int firstInFrame) {
        return rolls[firstInFrame] == 10;
    }

    bool IsSpare(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1] == 10;
    }
}