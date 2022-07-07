namespace PrimeFactors;

public class PrimeFactors {
  public PrimeFactors(Sieve sieve) {
  }

  public IEnumerable<long> Of(long n) {
    List<long> factors = new();

    if (n > 1) {
      while (n % 2 == 0) {
        factors.Add(2);
        n /= 2;
      }
    }

    if (n > 1) {
      factors.Add(n);
    }

    return factors;
  }
}
