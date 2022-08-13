namespace BowlingGame.Tests;

public class BowlingGameTests
{
    private readonly Game game;

    public BowlingGameTests()
    {
        game = new Game();
    }

    [Fact]
    public void RollAllZeros_ScoreShouldBeZero()
    {
        for (int i = 0; i < 20; i++)
        {
            game.Roll(0);
        }
        Assert.Equal(0, game.Score());
    }
}