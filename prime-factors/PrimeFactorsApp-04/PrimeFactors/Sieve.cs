namespace PrimeFactors;

public class Sieve {
  public IEnumerable<long> PrimesUpTo(long n) {
    List<long> primes = new();
    if (n > 1) {
      primes.Add(n);
    }

    return primes;
  }
}