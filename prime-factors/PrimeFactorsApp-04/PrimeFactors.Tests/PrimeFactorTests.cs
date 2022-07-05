namespace PrimeFactors.Tests;

public class PrimeFactorTests {
  [Fact]
  public void PrimeFactorsOfTest() {
    PrimeFactors primeFactors = new();
    Assert.Empty(primeFactors.Of(1L));
  }
}
