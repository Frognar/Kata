namespace PrimeFactors.Tests;

public class PrimeFactorsTest {
  [Fact]
  public void FactorsOfTest() {
    PrimeFactors primeFactors = new();
    Assert.Equal(Enumerable.Empty<int>(), primeFactors.Of(1));
    Assert.Equal(new List<int> { 2 }, primeFactors.Of(2));
  }
}
