namespace PrimeFactors;

public class Sieve : PrimeGenerator {
  public IEnumerable<int> GetPrimesUpTo(int n) {
    List<int> primes = new();
    IEnumerable<int> candidates = GetCandidatesUpTo(n);
    if (candidates.Any()) {
      for (int first = candidates.First();
        first > 0 && first <= n;
        candidates = candidates.Except(GetMultiplesOf(first, n)).ToList(),
        first = candidates.FirstOrDefault()) {
        primes.Add(first);
      }
    }

    return primes;
  }

  static IEnumerable<int> GetCandidatesUpTo(int n) {
    List<int> candidates = new();
    for (int i = 2; i <= n; i++) {
      candidates.Add(i);
    }

    return candidates;
  }

  static IEnumerable<int> GetMultiplesOf(int n, int limit) {
    for (int multiple = n; multiple <= limit; multiple += n) {
      yield return multiple;
    } 
  }
}
