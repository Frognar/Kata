namespace PrimeFactors;

public class Sieve {
  public IEnumerable<long> PrimesUpTo(long n) {
    if (n < 2) {
      return Enumerable.Empty<long>();
    }

    bool[] composites = new bool[n + 1];
    List<long> primes = new();
    for (long candidate = 2; candidate <= n; candidate++) {
      if (composites[candidate] == false) {
        primes.Add(candidate);
        for (long multiply = 2 * candidate; multiply <= n; multiply += candidate) {
          composites[multiply] = true;
        }
      }
    }

    return primes;
  }
}