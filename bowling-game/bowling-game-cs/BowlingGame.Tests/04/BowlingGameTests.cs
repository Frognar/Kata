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

  [Fact]
  public void AllZeros() {
    for (int i = 0; i < 20; i++) {
      game.Roll(0);
    }
    Assert.Equal(0, game.Score());
  }
}