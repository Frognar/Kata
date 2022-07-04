namespace PrimeFactors;

public class PrimeFactors {
  public IEnumerable<long> Of(long n) {
    List<long> factors = new();
    for (long divisior = 2; n > 1; divisior++) {
      for (; n % divisior == 0; n /= divisior) {
        factors.Add(divisior);
      }
    }

    return factors;
  }
}
