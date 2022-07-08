namespace PrimeFactors.Tests;

public class SieveTest {
  [Fact]
  public void PrimesUpToTest() {
    Sieve sieve = new();
    Assert.Empty(sieve.PrimesUpTo(1L));
    Assert.Equal(new List<long> { 2 }, sieve.PrimesUpTo(2));
  }
}