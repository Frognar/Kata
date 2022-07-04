namespace PrimeFactors;

public class Sieve : PrimeGenerator {
  public IEnumerable<long> GetPrimesUpTo(long n) {
    HashSet<long> primes = new();
    for (int i = 2; i <= n; i++) {
      if (primes.All(p => i % p != 0)) {
        primes.Add(i);
      }
    }

    return primes;
  }
}