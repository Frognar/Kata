﻿namespace PrimeFactors.Tests;

public class PrimeFactorsTest {
  [Fact]
  public void PrimeFactorsOfTest() {
    PrimeFactors primeFactors = new();
    Assert.Empty(primeFactors.Of(1));
    Assert.Equal(new List<long> { 2 }, primeFactors.Of(2));
    Assert.Equal(new List<long> { 3 }, primeFactors.Of(3));
    Assert.Equal(new List<long> { 2, 2 }, primeFactors.Of(4));
  }
}
