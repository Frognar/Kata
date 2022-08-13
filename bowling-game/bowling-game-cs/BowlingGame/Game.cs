namespace BowlingGame;

public class Game
{
    private int[] rolls = new int[21];
    private int currentRoll = 0;
    
    public void Roll(int pins)
    {
        rolls[currentRoll++] = pins;
    }

    public int Score()
    {
        int score = 0;
        for (int i = 0; i < 20; i++)
        {
            score += rolls[i];
        }
        return score;
    }
}