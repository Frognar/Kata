namespace BowlingGame.Tests;

public class BowlingGameTests
{
    private readonly Game game;

    public BowlingGameTests()
    {
        game = new Game();
    }

    [Fact]
    public void CanRoll()
    {
        game.Roll(0);
    }
}