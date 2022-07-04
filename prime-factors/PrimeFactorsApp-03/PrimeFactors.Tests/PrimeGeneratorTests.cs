namespace PrimeFactors.Tests;

public class PrimeGeneratorTests {
  [Fact]
  public void PrimesUpToTest() {
    PrimeGenerator generator = new Sieve();
    Assert.Empty(generator.GetPrimesUpTo(1));
    Assert.Equal(new List<long> { 2 }, generator.GetPrimesUpTo(2));
  }
}
