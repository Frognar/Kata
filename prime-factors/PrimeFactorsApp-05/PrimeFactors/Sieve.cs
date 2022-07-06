namespace PrimeFactors;

public class Sieve {
  public IEnumerable<long> GetPrimesUpTo(long n) {
    List<long> primes = new();
    for (long candidate = 2; candidate <= n; candidate++) {
      primes.Add(candidate);
    }

    return primes;
  }
}
