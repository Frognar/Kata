﻿namespace PrimeFactors.Tests;

public class PrimeFactorsTest {
  [Fact]
  public void SieveIsPrimeGeneratorTest() {
    Sieve generator = new();
    _ = Assert.IsAssignableFrom<PrimeGenerator>(generator);
  }

  [Fact]
  public void RemoveMultiplesOfFirstTest() {
    Assert.Equal(Enumerable.Empty<int>(), Sieve.RemoveMultiplesOfFirst(Enumerable.Empty<int>()));
    Assert.Equal(Enumerable.Empty<int>(), Sieve.RemoveMultiplesOfFirst(new List<int> { 2 }));
    Assert.Equal(new List<int> { 3 }, Sieve.RemoveMultiplesOfFirst(new List<int> { 2, 3 }));
    Assert.Equal(new List<int> { 3 }, Sieve.RemoveMultiplesOfFirst(new List<int> { 2, 3, 4 }));
    Assert.Equal(new List<int> { 3, 5 }, Sieve.RemoveMultiplesOfFirst(new List<int> { 2, 3, 4, 5 }));
    Assert.Equal(new List<int> { 4, 5 }, Sieve.RemoveMultiplesOfFirst(new List<int> { 3, 4, 5, 6 }));
    Assert.Equal(new List<int> { 1, 2, 3 }, Sieve.RemoveMultiplesOfFirst(new List<int> { 0, 1, 2, 3 }));
  }

  [Fact]
  public void GetPrimesUpToTest() {
    PrimeGenerator generator = new Sieve();
    Assert.Equal(Enumerable.Empty<int>(), generator.GetPrimesUpTo(1));
    Assert.Equal(new List<int> { 2 }, generator.GetPrimesUpTo(2));
    Assert.Equal(new List<int> { 2, 3 }, generator.GetPrimesUpTo(3));
    Assert.Equal(new List<int> { 2, 3 }, generator.GetPrimesUpTo(4));
  }

  [Fact]
  public void FactorsOfTest() {
    PrimeGenerator generator = new TestPrimeGenerator();
    PrimeFactors primeFactors = new(generator);
    Assert.Equal(Enumerable.Empty<int>(), primeFactors.Of(1));
    Assert.Equal(new List<int> { 2 }, primeFactors.Of(2));
    Assert.Equal(new List<int> { 3 }, primeFactors.Of(3));
    Assert.Equal(new List<int> { 2, 2 }, primeFactors.Of(4));
  }

  class TestPrimeGenerator : PrimeGenerator {
    public IEnumerable<int> GetPrimesUpTo(int n) {
      return new List<int> { 2, 3 };
    }
  }
}
