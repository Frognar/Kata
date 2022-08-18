using BowlingGame._06;

namespace BowlingGame.Tests._06; 

public class BowlingGameTests {
  [Fact]
  public void CanCreateGame() {
    Game game = new();
  }

  [Fact]
  public void CanRoll() {
    Game game = new();
    game.Roll(0);
  }
}