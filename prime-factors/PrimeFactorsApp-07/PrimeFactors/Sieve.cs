namespace PrimeFactors;

public class Sieve {
  public IEnumerable<long> PrimesUpTo(long limit) {
    List<long> primes = new();
    if (limit > 1) {
      primes.Add(limit);
    }

    return primes;
  }
}