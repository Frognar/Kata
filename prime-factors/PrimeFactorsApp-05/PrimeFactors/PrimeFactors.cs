namespace PrimeFactors;

public class PrimeFactors {
  readonly Sieve sieve;

  public PrimeFactors(Sieve sieve) {
    this.sieve = sieve;
  }

  public IEnumerable<long> Of(long n) {
    List<long> factors = new();
    foreach (long prime in sieve.GetPrimesUpTo(n)) {
      if (n > 1) {
        while (n % prime == 0) {
          factors.Add(prime);
          n /= prime;
        }
      }
    }

    if (n > 1) {
      factors.Add(n);
    }

    return factors;
  }
}
