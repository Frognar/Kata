using BowlingGame._07;

namespace BowlingGame.Tests._07; 

public class BowlingGameTests {
  readonly Game game;

  public BowlingGameTests() {
    game = new Game();
  }

  [Fact]
  public void AllZeros() {
    for (int i = 0; i < 20; i++) {
      game.Roll(0);
    }

    Assert.Equal(0, game.Score());
  }

  [Fact]
  public void AllOnes() {
    for (int i = 0; i < 20; i++) {
      game.Roll(1);
    }

    Assert.Equal(20, game.Score());
  }
}