using BowlingGame._02;

namespace BowlingGame.Tests._02; 

public class BowlingGameTests {
    readonly Game game;

    public BowlingGameTests() {
        game = new Game();
    }

    [Fact]
    public void CanCreateGame() {
    }

    [Fact]
    public void CanRoll() {
        game.Roll(0);
    }
}