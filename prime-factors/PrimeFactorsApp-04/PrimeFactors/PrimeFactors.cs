namespace PrimeFactors;

public class PrimeFactors {
  Sieve sieve;

  public PrimeFactors(Sieve sieve) {
    this.sieve = sieve;
  }

  public IEnumerable<long> Of(long n) {
    if (n < 2) {
      return Enumerable.Empty<long>();
    }

    List<long> factors = new();
    long prime = sieve.PrimesUpTo(n).First();
    while (n % prime == 0) {
      factors.Add(prime);
      n /= prime;
    }
    
    if (n > 1) {
      factors.Add(n);
    }

    return factors;
  }
}
