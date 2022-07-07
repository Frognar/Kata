namespace PrimeFactors;

public class Sieve {
  public IEnumerable<long> PrimesUpTo(long n) {
    if (n < 2) {
      return Enumerable.Empty<long>();
    }

    return new List<long> { 2 };
  }
}