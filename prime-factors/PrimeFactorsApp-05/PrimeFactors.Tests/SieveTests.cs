namespace PrimeFactors.Tests;

public class SieveTests {
  [Fact]
  public void GetPrimesUpToTest() {
    Sieve sieve = new();
    Assert.Empty(sieve.GetPrimesUpTo(1L));
  }
}