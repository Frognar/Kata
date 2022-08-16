﻿namespace BowlingGame._04; 

public class Game {
  readonly int[] rolls = new int[21];
  int currentRoll;
  
  public void Roll(int pins) {
    rolls[currentRoll++] = pins;
  }

  public int Score() {
    int score = 0;
    int firstInFrame = 0;
    for (int frame = 0; frame < 10; frame++) {
      if (IsStrike(firstInFrame)) {
        score += 10 + rolls[firstInFrame + 1] + rolls[firstInFrame + 2];
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
    }
    return score;
  }

  bool IsStrike(int firstInFrame) => rolls[firstInFrame] == 10;

  bool IsSpare(int firstInFrame) => rolls[firstInFrame] + rolls[firstInFrame + 1] == 10;

  int NextBallForSpare(int firstInFrame) => rolls[firstInFrame + 2];

  int TwoBallsInFrame(int firstInFrame) => rolls[firstInFrame] + rolls[firstInFrame + 1];
}