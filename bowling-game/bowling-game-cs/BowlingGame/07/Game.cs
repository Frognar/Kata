namespace BowlingGame._07; 

public class Game {
  int score;
  
  public void Roll(int pins) {
    score += pins;
  }

  public int Score() {
    return score;
  }
}