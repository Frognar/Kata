namespace PrimeFactors;
public class PrimeFactors {
  public PrimeFactors(Sieve sieve) {
  }

  public IEnumerable<long> Of(long n) {
    List<long> factors = new();
    long prime = 2;
    if (n > 1) {
      while (n % prime == 0) {
        factors.Add(prime);
        n /= prime;
      }
    }
    
    if (n > 1) {
      factors.Add(n);
    }

    return factors;
  }
}
