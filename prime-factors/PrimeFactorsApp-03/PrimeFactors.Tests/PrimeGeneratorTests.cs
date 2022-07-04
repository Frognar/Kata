﻿namespace PrimeFactors.Tests;

public class PrimeGeneratorTests {
  [Fact]
  public void PrimesUpToTest() {
    PrimeGenerator generator = new Sieve();
    Assert.Empty(generator.GetPrimesUpTo(1));
    Assert.Equal(new List<long> { 2 }, generator.GetPrimesUpTo(2));
    Assert.Equal(new List<long> { 2, 3 }, generator.GetPrimesUpTo(3));
    Assert.Equal(new List<long> { 2, 3 }, generator.GetPrimesUpTo(4));
  }
}
