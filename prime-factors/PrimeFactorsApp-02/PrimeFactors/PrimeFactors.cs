namespace PrimeFactors;

public class PrimeFactors {
  public IEnumerable<int> Of(int n) {
    List<int> factors = new();
    if (n > 1) {
      factors.Add(2);
    }

    return factors;
  }
}
