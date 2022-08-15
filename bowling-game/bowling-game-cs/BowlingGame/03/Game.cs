namespace BowlingGame._03; 

public class Game {
  int score = 0;
  public void Roll(int pins) {
    score += pins;
  }

  public int Score() {
    return score;
  }
}