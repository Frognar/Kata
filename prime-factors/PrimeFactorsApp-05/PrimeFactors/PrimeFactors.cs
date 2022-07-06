namespace PrimeFactors;

public class PrimeFactors {
  readonly Sieve sieve;

  public PrimeFactors(Sieve sieve) {
    this.sieve = sieve;
  }

  public IEnumerable<long> Of(long n) {
    if (n < 2) {
      return Enumerable.Empty<long>();
    }

    List<long> factors = new();
    long limit = (long)Math.Sqrt(n) + 1;
    foreach (long prime in sieve.GetPrimesUpTo(limit)) {
      for (; n % prime == 0; n /= prime) {
        factors.Add(prime);
      }
    }

    if (n > 1) {
      factors.Add(n);
    }

    return factors;
  }
}
