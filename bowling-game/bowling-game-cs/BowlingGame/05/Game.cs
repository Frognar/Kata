namespace BowlingGame._05; 

public class Game {
  readonly int[] rolls = new int[21];
  int currentRoll;

  public void Roll(int pins) {
    rolls[currentRoll++] = pins;
  }

  public int Score() {
    int score = 0;
    for (int i = 0; i < rolls.Length; i++) {
      score += rolls[i];
    }
    return score;
  }
}