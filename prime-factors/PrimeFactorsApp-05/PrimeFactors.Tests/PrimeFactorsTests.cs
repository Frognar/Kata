namespace PrimeFactors.Tests;

public class PrimeFactorsTests {
  [Fact]
  public void PrimeFactorsTest() {
    PrimeFactors primeFactors = new();
    Assert.Empty(primeFactors.Of(1));
  }
}
