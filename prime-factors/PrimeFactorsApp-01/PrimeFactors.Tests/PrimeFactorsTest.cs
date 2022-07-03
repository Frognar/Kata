namespace PrimeFactors.Tests;

public class PrimeFactorsTest {
  [Fact]
  public void FactorsOfTest() {
    PrimeFactors primeFactors = new();
    Assert.Equal(Enumerable.Empty<int>(), primeFactors.Of(1));
    Assert.Equal(new List<int> { 2 }, primeFactors.Of(2));
    Assert.Equal(new List<int> { 3 }, primeFactors.Of(3));
    Assert.Equal(new List<int> { 2, 2 }, primeFactors.Of(4));
    Assert.Equal(new List<int> { 5 }, primeFactors.Of(5));
    Assert.Equal(new List<int> { 2, 3 }, primeFactors.Of(6));
    Assert.Equal(new List<int> { 7 }, primeFactors.Of(7));
    Assert.Equal(new List<int> { 2, 2, 2 }, primeFactors.Of(8));
    Assert.Equal(new List<int> { 3, 3 }, primeFactors.Of(9));
    Assert.Equal(new List<int> { 2, 2, 3, 5, 7, 11, 11, 13 }, primeFactors.Of(2 * 2 * 3 * 5 * 7 * 11 * 11 * 13));
    Assert.Equal(new List<int> { 90499 }, primeFactors.Of(90499));
    Assert.Equal(new List<int> { (int)Math.Pow(2, 31) - 1 }, primeFactors.Of((int)Math.Pow(2, 31) - 1));
  }
}
