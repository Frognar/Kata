namespace PrimeFactors.Tests;

public class SieveTests {
  [Fact]
  public void GetPrimesUpToTest() {
    Sieve sieve = new();
    Assert.Empty(sieve.GetPrimesUpTo(1));
    Assert.Equal(new List<long> { 2 }, sieve.GetPrimesUpTo(2));
    Assert.Equal(new List<long> { 2, 3 }, sieve.GetPrimesUpTo(3));
    Assert.Equal(new List<long> { 2, 3 }, sieve.GetPrimesUpTo(4));
    Assert.Equal(new List<long> { 2, 3, 5 }, sieve.GetPrimesUpTo(5));
    Assert.Equal(new List<long> { 2, 3, 5 }, sieve.GetPrimesUpTo(6));
    Assert.Equal(new List<long> { 2, 3, 5, 7 }, sieve.GetPrimesUpTo(7));
    Assert.Equal(new List<long> { 2, 3, 5, 7 }, sieve.GetPrimesUpTo(8));
    Assert.Equal(new List<long> { 2, 3, 5, 7 }, sieve.GetPrimesUpTo(9));
    Assert.Equal(new List<long> { 2, 3, 5, 7 }, sieve.GetPrimesUpTo(10));
    Assert.Equal(new List<long> { 2, 3, 5, 7, 11 }, sieve.GetPrimesUpTo(11));
  }
}