namespace PrimeFactors;

public class PrimeFactors {
  public IEnumerable<long> Of(long n) {
    List<long> factors = new();
    long divisior = 2;
    while (n > 1) {
      while (n % divisior == 0) {
        factors.Add(divisior);
        n /= divisior;
      }

      divisior++;
    }

    if (n > 1) {
      factors.Add(n);
    }

    return factors;
  }
}
