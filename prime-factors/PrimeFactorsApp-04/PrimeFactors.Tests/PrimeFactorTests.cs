namespace PrimeFactors.Tests;

public class PrimeFactorTests {
  [Fact]
  public void PrimeFactorsOfTest() {
    PrimeFactors primeFactors = new();
    Assert.Empty(primeFactors.Of(1));
    Assert.Equal(new List<long> { 2 }, primeFactors.Of(2));
  }
}
