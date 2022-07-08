namespace PrimeFactors.Tests;
public class PrimeFactorsTest {
  [Fact]
  public void FactorsOfTest() {
    PrimeFactors factors = new(new Sieve());
    Assert.Empty(factors.Of(1L));
    Assert.Equal(new List<long> { 2 }, factors.Of(2));
    Assert.Equal(new List<long> { 3 }, factors.Of(3));
    Assert.Equal(new List<long> { 2, 2 }, factors.Of(4));
    Assert.Equal(new List<long> { 5 }, factors.Of(5));
    Assert.Equal(new List<long> { 2, 3 }, factors.Of(6));
    Assert.Equal(new List<long> { 7 }, factors.Of(7));
    Assert.Equal(new List<long> { 2, 2, 2 }, factors.Of(8));
    Assert.Equal(new List<long> { 3, 3 }, factors.Of(9));
    Assert.Equal(new List<long> { 2, 2, 3, 5, 7, 11 }, factors.Of(2 * 2 * 3 * 5 * 7 * 11));
    Assert.Equal(new List<long> { 2, 2, 3, 5, 7, 11, 11, 13 }, factors.Of(2 * 2 * 3 * 5 * 7 * 11 * 11 * 13));
    Assert.Equal(new List<long> { (long)Math.Pow(2, 31) - 1 }, factors.Of((long)Math.Pow(2, 31) - 1));
    //Assert.Equal(new List<long> { (long)Math.Pow(2, 61) - 1 }, factors.Of((long)Math.Pow(2, 61) - 1));
  }
}
