namespace PrimeFactors;

public class Sieve {
  public IEnumerable<long> PrimesUpTo(long limit) {
    List<long> primes = new();
    for (long candidate = 2; candidate <= limit; candidate++) {
      primes.Add(candidate);
    }

    return primes;
  }
}