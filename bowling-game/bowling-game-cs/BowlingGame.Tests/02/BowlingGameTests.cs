﻿using BowlingGame._02;

namespace BowlingGame.Tests._02; 

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
}