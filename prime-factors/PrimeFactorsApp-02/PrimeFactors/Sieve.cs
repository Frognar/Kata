namespace PrimeFactors;

public class Sieve : PrimeGenerator {
  public IEnumerable<int> GetPrimesUpTo(int n)
    => n < 2 ? Enumerable.Empty<int>() : PrimesUpTo(n);

  static IEnumerable<int> PrimesUpTo(int n) {
    List<int> primes = new();
    bool[] composites = new bool[n + 1];

    for (int candidate = 2; candidate <= n; candidate++) {
      if (composites[candidate] == false) {
        primes.Add(candidate);
        for (int multiple = 2 * candidate; multiple <= n; multiple += candidate) {
          composites[multiple] = true;
        }
      }
    }

    return primes;
  }
}
