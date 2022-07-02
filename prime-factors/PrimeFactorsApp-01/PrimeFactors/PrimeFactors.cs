namespace PrimeFactors;

public class PrimeFactors {
  public IEnumerable<int> Of(int n) {
    List<int> factors = new();
    int divisor = 2;
    while (n > 1) {
      while (n % divisor == 0) {
        factors.Add(divisor);
        n /= divisor;
      }

      divisor++;
    }

    return factors;
  }
}
