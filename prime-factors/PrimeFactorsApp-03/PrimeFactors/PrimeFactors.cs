namespace PrimeFactors;

public class PrimeFactors {
  readonly PrimeGenerator generator;

  public PrimeFactors(PrimeGenerator generator) {
    this.generator = generator;
  }

  public IEnumerable<long> Of(long n) {
    if (n < 2) {
      return Enumerable.Empty<long>();
    }

    long limit = (long)Math.Sqrt(n) + 1;
    List<long> factors = new();
    foreach (long prime in generator.GetPrimesUpTo(limit)) {
      for (; n % prime == 0; n /= prime) {
        factors.Add(prime);
      }
    }

    if (factors.Count == 0) {
      factors.Add(n);
    }

    return factors;
  }
}
