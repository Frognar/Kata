using BowlingGame._06;

namespace BowlingGame.Tests._06; 

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