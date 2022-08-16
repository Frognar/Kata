using BowlingGame._04;

namespace BowlingGame.Tests._04; 

public class BowlingGameTests {
  readonly Game game;

  public BowlingGameTests() {
    game = new();
  }

  [Fact]
  public void CanRoll() {
    game.Roll(0);
  }
}