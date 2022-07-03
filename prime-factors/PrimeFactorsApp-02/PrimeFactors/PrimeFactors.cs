namespace PrimeFactors;

public class PrimeFactors {
  readonly PrimeGenerator generator;

  public PrimeFactors(PrimeGenerator generator) {
    this.generator = generator;
  }

  public IEnumerable<int> Of(int n) {
    List<int> factors = new();
    if (n > 1) {
      factors.Add(n);
    }

    return factors;
  }
}
