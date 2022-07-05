namespace PrimeFactors.Tests;

public class PrimeFactorTests {
  [Fact]
  public void PrimeFactorsOfTest() {
    PrimeFactors primeFactors = new();
    Assert.Empty(primeFactors.Of(1));
    Assert.Equal(new List<long> { 2 }, primeFactors.Of(2));
    Assert.Equal(new List<long> { 3 }, primeFactors.Of(3));
    Assert.Equal(new List<long> { 2, 2 }, primeFactors.Of(4));
    Assert.Equal(new List<long> { 5 }, primeFactors.Of(5));
    Assert.Equal(new List<long> { 2, 3 }, primeFactors.Of(6));
    Assert.Equal(new List<long> { 7 }, primeFactors.Of(7));
    Assert.Equal(new List<long> { 2, 2, 2 }, primeFactors.Of(8));
    //Assert.Equal(new List<long> { 3, 3 }, primeFactors.Of(9));
  }
}
