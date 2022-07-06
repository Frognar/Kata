namespace PrimeFactors.Tests;

public class SieveTests {
  [Fact]
  public void GetPrimesUpToTest() {
    Sieve sieve = new();
    Assert.Empty(sieve.GetPrimesUpTo(1));
    Assert.Equal(new List<long> { 2 }, sieve.GetPrimesUpTo(2));
    Assert.Equal(new List<long> { 2, 3 }, sieve.GetPrimesUpTo(3));
  }
}