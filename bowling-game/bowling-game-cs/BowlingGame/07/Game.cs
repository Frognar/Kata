﻿namespace BowlingGame._07; 

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
      if (TwoBallsInFrame(firstInFrame) == 10) {
        score += 10 + rolls[firstInFrame + 2];
        firstInFrame += 2;
      }
      else {
        score += TwoBallsInFrame(firstInFrame);
        firstInFrame += 2;
      }
    }
    return score;
  }

  int TwoBallsInFrame(int firstInFrame) => rolls[firstInFrame] + rolls[firstInFrame + 1];
}