namespace BowlingGame.Tests;

public class BowlingGameTests
{
    private readonly Game game;

    public BowlingGameTests()
    {
        game = new Game();
    }

    private void RollMany(int n, int pins)
    {
        for (int i = 0; i < n; i++)
        {
            game.Roll(pins);
        }
    }

    private void RollSpare()
    {
        game.Roll(5);
        game.Roll(5);
    }

    [Fact]
    public void RollAllZeros_ScoreShouldBeZero()
    {
        RollMany(20, 0);
        Assert.Equal(0, game.Score());
    }

    [Fact]
    public void RollAllOnes_ScoreShouldBeTwenty()
    {
        RollMany(20, 1);
        Assert.Equal(20, game.Score());
    }

    [Fact]
    public void OneSpare()
    {
        RollSpare();
        game.Roll(3);
        RollMany(17, 0);
        Assert.Equal(16, game.Score());
    }
}