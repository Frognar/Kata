namespace BowlingGame._07; 

public class Game {
  readonly int[] rolls = new int[21];
  int currentRoll;
  
  public void Roll(int pins) {
    rolls[currentRoll++] = pins;
  }

  public int Score() {
    int score = 0;
    int firstInFrame = 0;
    for (int i = 0; i < 10; i++) {
      if (IsStrike(firstInFrame)) {
        score += 10 + TwoBallsInFrame(++firstInFrame);
      }
      else if (IsSpare(firstInFrame)) {
        score += 10 + NextBallForSpare(firstInFrame);
        firstInFrame += 2;
      }
      else {
        score += TwoBallsInFrame(firstInFrame);
        firstInFrame += 2;
      }
    }
    return score;
  }

  bool IsStrike(int firstInFrame) => rolls[firstInFrame] == 10;

  bool IsSpare(int firstInFrame) => TwoBallsInFrame(firstInFrame) == 10;

  int NextBallForSpare(int firstInFrame) => rolls[firstInFrame + 2];

  int TwoBallsInFrame(int firstInFrame) => rolls[firstInFrame] + rolls[firstInFrame + 1];
}