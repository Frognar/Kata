namespace PrimeFactors;

public class Sieve {
  public IEnumerable<long> PrimesUpTo(long limit) {
    List<long> primes = new();
    bool[] composites = new bool[limit + 1];
    for (long candidate = 2; candidate <= limit; candidate++) {
      if (composites[candidate] == false) {
        primes.Add(candidate);
        for (long multiply = 2 * candidate; multiply <= limit; multiply += candidate) {
          composites[multiply] = true;
        }
      }
    }

    return primes;
  }
}