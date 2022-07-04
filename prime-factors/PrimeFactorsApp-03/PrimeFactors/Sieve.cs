namespace PrimeFactors;

public class Sieve : PrimeGenerator {
  public IEnumerable<long> GetPrimesUpTo(long n)
    => n < 2 ? Enumerable.Empty<long>() : PrimesUpTo(n);

  static IEnumerable<long> PrimesUpTo(long n) {
    List<long> primes = new();
    bool[] composites = new bool[n + 1];

    for (long candidate = 2; candidate <= n; candidate++) {
      if (composites[candidate] == false) {
        primes.Add(candidate);
        for (long multiple = 2 * candidate; multiple <= n; multiple += candidate) {
          composites[multiple] = true;
        }
      }
    }

    return primes;
  }
}