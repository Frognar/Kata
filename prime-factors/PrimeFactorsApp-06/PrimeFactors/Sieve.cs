namespace PrimeFactors;

public class Sieve {
  public IEnumerable<long> PrimesUpTo(long n) {
    if (n < 2) {
      return Enumerable.Empty<long>();
    }

    List<long> primes = new();
    for (long candidate = 2; candidate <= n; candidate++) {
      primes.Add(candidate);
    }

    return primes;
  }
}