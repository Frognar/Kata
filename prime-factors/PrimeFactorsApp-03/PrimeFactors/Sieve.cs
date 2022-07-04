namespace PrimeFactors;

public class Sieve : PrimeGenerator {
  public IEnumerable<long> GetPrimesUpTo(long n) {
    for (int i = 2; i <= n; i++) {
      yield return i;
    }
  }
}