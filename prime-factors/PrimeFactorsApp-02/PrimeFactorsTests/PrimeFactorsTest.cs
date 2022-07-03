﻿namespace PrimeFactors.Tests;

public class PrimeFactorsTest {
  [Fact]
  public void GetPrimesUpToTest() {
    Sieve generator = new();
    _ = Assert.IsAssignableFrom<PrimeGenerator>(generator);
    Assert.Equal(Enumerable.Empty<int>(), generator.RemoveMultiplesOfFirst(Enumerable.Empty<int>()));
    Assert.Equal(Enumerable.Empty<int>(), generator.RemoveMultiplesOfFirst(new List<int> { 2 }));
    Assert.Equal(new List<int> { 3 }, generator.RemoveMultiplesOfFirst(new List<int> { 2, 3 }));
    Assert.Equal(new List<int> { 3 }, generator.RemoveMultiplesOfFirst(new List<int> { 2, 3, 4 }));
    Assert.Equal(new List<int> { 3, 5 }, generator.RemoveMultiplesOfFirst(new List<int> { 2, 3, 4, 5 }));
    Assert.Equal(new List<int> { 4, 5 }, generator.RemoveMultiplesOfFirst(new List<int> { 3, 4, 5, 6 }));
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
