﻿using BowlingGame._05;

namespace BowlingGame.Tests._05; 

public class BowlingGameTests {
  readonly Game game;

  public BowlingGameTests() {
    game = new Game();
  }

  void RollMany(int n, int pins) {
    for (var i = 0; i < n; i++) {
      game.Roll(pins);
    }
  }

  [Fact]
  public void AllZeros() {
    RollMany(20, 0);
    Assert.Equal(0, game.Score());
  }

  [Fact]
  public void AllOnes() {
    RollMany(20, 1);
    Assert.Equal(20, game.Score());
  }

  [Fact]
  public void OneSpare() {
    game.Roll(5);
    game.Roll(5);
    game.Roll(3);
    RollMany(17, 0);
    Assert.Equal(16, game.Score());
  }
}