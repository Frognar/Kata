namespace PrimeFactors.Tests;

public class PrimeFactorsTest {
  [Fact]
  public void PrimeFactorsOfTest() {
    PrimeFactors primeFactors = new();
    Assert.Empty(primeFactors.Of(1));
  }
}
