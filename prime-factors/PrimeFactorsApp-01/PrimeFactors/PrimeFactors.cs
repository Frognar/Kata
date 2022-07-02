namespace PrimeFactors;

public class PrimeFactors {
  public IEnumerable<int> Of(int n) {
    List<int> factors = new();
    for (int divisor = 2; n > 1; divisor++) {
      for (; n % divisor == 0; n /= divisor) {
        factors.Add(divisor);
      }
    }

    return factors;
  }
}
