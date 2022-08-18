using BowlingGame._06;

namespace BowlingGame.Tests._06; 

public class BowlingGameTests {
  readonly Game game;

  public BowlingGameTests() {
    game = new Game();
  }

  void RollMany(int n, int pins) {
    for (int i = 0; i < n; i++) {
      game.Roll(pins);
    }
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

  [Fact]
  public void OneSpare() {
    game.Roll(5);
    game.Roll(5);
    game.Roll(6);
    RollMany(17, 0);
    Assert.Equal(22, game.Score());
  }
}