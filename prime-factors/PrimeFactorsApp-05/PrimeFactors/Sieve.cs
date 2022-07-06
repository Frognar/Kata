namespace PrimeFactors;

public class Sieve {
  public IEnumerable<long> GetPrimesUpTo(long n) {
    List<long> primes = new();
    if (n > 1) {
      primes.Add(n);
    }

    return primes;
  }
}
