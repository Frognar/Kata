namespace PrimeFactors.Tests;
public class PrimeFactorsTest {
  [Fact]
  public void FactorsOfTest() {
    PrimeFactors factors = new();
    Assert.Empty(factors.Of(1L));
    Assert.Equal(new List<long> { 2 }, factors.Of(2));
  }
}
