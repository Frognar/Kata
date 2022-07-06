namespace PrimeFactors;

public class Sieve {
  public IEnumerable<long> GetPrimesUpTo(long n) {
    if (n < 2) {
      return Enumerable.Empty<long>();
    }

    return PrimesUpTo(n);
  }

  IEnumerable<long> PrimesUpTo(long n) {
    List<long> primes = new();
    bool[] composites = new bool[n + 1];
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
