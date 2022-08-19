using BowlingGame._07;

namespace BowlingGame.Tests._07; 

public class BowlingGameTests {
  readonly Game game;

  public BowlingGameTests() {
    game = new Game();
  }

  [Fact]
  public void CanRoll() {
    game.Roll(0);
  }
}