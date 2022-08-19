using BowlingGame._07;

namespace BowlingGame.Tests._07; 

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

  void RollSpare() {
    game.Roll(5);
    game.Roll(5);
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
    RollSpare();
    game.Roll(9);
    RollMany(17, 0);
    Assert.Equal(28, game.Score());
  }

  [Fact]
  public void OneStrike() {
    game.Roll(10);
    game.Roll(8);
    game.Roll(1);
    RollMany(16, 0);
    Assert.Equal(28, game.Score());
  }
}