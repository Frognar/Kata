namespace PrimeFactors;

public class PrimeFactors {
   readonly PrimeGenerator generator;

  public PrimeFactors(PrimeGenerator generator) {
    this.generator = generator;
  }

  public IEnumerable<int> Of(int n) {
    if (n < 2) {
      return Enumerable.Empty<int>();
    }

    int limit = (int)Math.Sqrt(n) + 1;
    List<int> factors = new();
    foreach (int prime in generator.GetPrimesUpTo(limit)) {
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
