namespace PrimeFactors.Tests;

public class PrimeFactorsTest {
  [Fact]
  public void GetPrimesUpToTest() {
    PrimeGenerator generator = new Sieve();
    Assert.Equal(Enumerable.Empty<int>(), generator.GetPrimesUpTo(1));
    Assert.Equal(new List<int> { 2 }, generator.GetPrimesUpTo(2));
    Assert.Equal(new List<int> { 2, 3 }, generator.GetPrimesUpTo(3));
    Assert.Equal(new List<int> { 2, 3 }, generator.GetPrimesUpTo(4));
    Assert.Equal(new List<int> { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 }, generator.GetPrimesUpTo(100));
  }

  [Fact]
  public void FactorsOfTest() {
    PrimeGenerator generator = new Sieve();
    PrimeFactors primeFactors = new(generator);
    Assert.Equal(Enumerable.Empty<int>(), primeFactors.Of(1));
    Assert.Equal(new List<int> { 2 }, primeFactors.Of(2));
    Assert.Equal(new List<int> { 3 }, primeFactors.Of(3));
    Assert.Equal(new List<int> { 2, 2 }, primeFactors.Of(4));
    Assert.Equal(new List<int> { 5 }, primeFactors.Of(5));
    Assert.Equal(new List<int> { 2, 3 }, primeFactors.Of(6));
    Assert.Equal(new List<int> { 7 }, primeFactors.Of(7));
    Assert.Equal(new List<int> { 2, 2, 2 }, primeFactors.Of(8));
    Assert.Equal(new List<int> { 3, 3 }, primeFactors.Of(9));
    Assert.Equal(new List<int> { 2, 2, 3, 5, 7, 11 }, primeFactors.Of(2 * 2 * 3 * 5 * 7 * 11));
  }
}
