﻿namespace BowlingGame;

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
        int firstInFrame = 0;
        for (int frame = 0; frame < 10; frame++)
        {
            score += rolls[firstInFrame] + rolls[firstInFrame + 1];
            firstInFrame += 2;
        }
        return score;
    }
}