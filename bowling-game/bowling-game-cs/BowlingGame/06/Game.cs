namespace BowlingGame._06; 

public class Game {
  int score;
  
  public void Roll(int pins) {
    score += pins;
  }

  public int Score() {
    return score;
  }
}