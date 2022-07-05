namespace PrimeFactors.Tests;

public class SieveTests {
  [Fact]
  public void GetPrimesUpTo() {
    Sieve sieve = new();
    Assert.Empty(sieve.PrimesUpTo(1L));
    Assert.Equal(new List<long> { 2 }, sieve.PrimesUpTo(2));
  }
}
