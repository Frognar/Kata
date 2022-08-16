using BowlingGame._04;

namespace BowlingGame.Tests._04; 

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