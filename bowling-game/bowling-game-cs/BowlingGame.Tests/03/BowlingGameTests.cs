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

  [Fact]
  public void AllZeros() {
    for (int i = 0; i < 20; i++) {
      game.Roll(0);
    }
    Assert.Equal(0, game.Score());
  }
}