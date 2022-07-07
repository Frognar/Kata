namespace PrimeFactors.Tests;

public class PrimeFactorsTests {
  [Fact]
  public void PrimeFactorsTest() {
    PrimeFactors primeFactors = new(new Sieve());
    Assert.Empty(primeFactors.Of(1));
    Assert.Equal(new List<long> { 2 }, primeFactors.Of(2));
    Assert.Equal(new List<long> { 3 }, primeFactors.Of(3));
    Assert.Equal(new List<long> { 2, 2 }, primeFactors.Of(4));
    Assert.Equal(new List<long> { 5 }, primeFactors.Of(5));
    Assert.Equal(new List<long> { 2, 3 }, primeFactors.Of(6));
    Assert.Equal(new List<long> { 7 }, primeFactors.Of(7));
    Assert.Equal(new List<long> { 2, 2, 2 }, primeFactors.Of(8));
    Assert.Equal(new List<long> { 3, 3 }, primeFactors.Of(9));
    Assert.Equal(new List<long> { 2, 5 }, primeFactors.Of(10));
    Assert.Equal(new List<long> { 11 }, primeFactors.Of(11));
    Assert.Equal(new List<long> { (long)Math.Pow(2, 31) - 1 }, primeFactors.Of((long)Math.Pow(2, 31) - 1));
    Assert.Equal(new List<long> { (long)Math.Pow(2, 61) - 1 }, primeFactors.Of((long)Math.Pow(2, 61) - 1));
  }
}
