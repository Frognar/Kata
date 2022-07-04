namespace PrimeFactors;

public class Sieve : PrimeGenerator {
  public IEnumerable<long> GetPrimesUpTo(long n) {
    if (n < 2) {
      return Enumerable.Empty<long>();
    }

    return new HashSet<long> { 2 };
  }
}