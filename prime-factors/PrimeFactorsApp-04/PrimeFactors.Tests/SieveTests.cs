namespace PrimeFactors.Tests;

public class SieveTests {
  [Fact]
  public void GetPrimesUpTo() {
    Sieve sieve = new();
    Assert.Empty(sieve.PrimesUpTo(1L));
    Assert.Equal(new List<long> { 2 }, sieve.PrimesUpTo(2));
    Assert.Equal(new List<long> { 2, 3 }, sieve.PrimesUpTo(3));
    Assert.Equal(new List<long> { 2, 3 }, sieve.PrimesUpTo(4));
    Assert.Equal(new List<long> { 2, 3, 5 }, sieve.PrimesUpTo(5));
    Assert.Equal(new List<long> { 2, 3, 5 }, sieve.PrimesUpTo(6));
    Assert.Equal(new List<long> { 2, 3, 5, 7 }, sieve.PrimesUpTo(7));
    Assert.Equal(new List<long> { 2, 3, 5, 7 }, sieve.PrimesUpTo(8));
    Assert.Equal(new List<long> { 2, 3, 5, 7 }, sieve.PrimesUpTo(9));
    Assert.Equal(new List<long> { 2, 3, 5, 7 }, sieve.PrimesUpTo(10));
    Assert.Equal(new List<long> { 2, 3, 5, 7, 11 }, sieve.PrimesUpTo(11));
  }
}
