using BowlingGame._04;

namespace BowlingGame.Tests._04; 

public class BowlingGameTests {
  readonly Game game;

  public BowlingGameTests() {
    game = new Game();
  }

  void RollMany(int n, int pins) {
    for (var i = 0; i < n; i++) {
      game.Roll(pins);
    }
  }

  [Fact]
  public void CanRoll() {
    game.Roll(0);
  }

  [Fact]
  public void AllZeros() {
    RollMany(20, 0);
    Assert.Equal(0, game.Score());
  }

  [Fact]
  public void AllOnes() {
    RollMany(20, 1);
    Assert.Equal(20, game.Score());
  }
}