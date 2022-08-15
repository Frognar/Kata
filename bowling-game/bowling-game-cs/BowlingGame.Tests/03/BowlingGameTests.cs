using BowlingGame._03;

namespace BowlingGame.Tests._03; 

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

  void RollStrike() {
    game.Roll(10);
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
    game.Roll(3);
    RollMany(17, 0);
    Assert.Equal(16, game.Score());
  }

  [Fact]
  public void OneStrike() {
    RollStrike();
    game.Roll(3);
    game.Roll(6);
    RollMany(16, 0);
    Assert.Equal(28, game.Score());
  }

  [Fact]
  public void AllStrikes() {
    RollMany(12, 10);
    Assert.Equal(300, game.Score());
  }
}