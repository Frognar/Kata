namespace PrimeFactors.Tests;

public class SieveTest {
  [Fact]
  public void PrimesUpToTest() {
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
    Assert.Equal(new List<long> { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 }, sieve.PrimesUpTo(100));
  }
}
