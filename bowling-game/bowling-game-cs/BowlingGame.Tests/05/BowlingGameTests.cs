using BowlingGame._05;

namespace BowlingGame.Tests._05; 

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