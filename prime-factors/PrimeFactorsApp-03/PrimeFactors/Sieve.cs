namespace PrimeFactors;

public class Sieve : PrimeGenerator {
  public IEnumerable<long> GetPrimesUpTo(long n) {
    if (n < 2) {
      return Enumerable.Empty<long>();
    }

    HashSet<long> primes = new();
    for (int i = 2; i <= n; i++) {
      primes.Add(i);
    }

    return primes;
  }
}