namespace PrimeFactors.Tests;

public class PrimeGeneratorTests {
  [Fact]
  public void PrimesUpToTest() {
    PrimeGenerator generator = new Sieve();
    Assert.Empty(generator.GetPrimesUpTo(1));
    Assert.Equal(new List<long> { 2 }, generator.GetPrimesUpTo(2));
    Assert.Equal(new List<long> { 2, 3 }, generator.GetPrimesUpTo(3));
    Assert.Equal(new List<long> { 2, 3 }, generator.GetPrimesUpTo(4));
    Assert.Equal(new List<long> { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 }, generator.GetPrimesUpTo(100));
  }
}
