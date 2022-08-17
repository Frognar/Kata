using BowlingGame._05;

namespace BowlingGame.Tests._05; 

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