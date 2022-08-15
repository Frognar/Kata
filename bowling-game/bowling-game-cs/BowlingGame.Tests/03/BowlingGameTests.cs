using BowlingGame._03;

namespace BowlingGame.Tests._03; 

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