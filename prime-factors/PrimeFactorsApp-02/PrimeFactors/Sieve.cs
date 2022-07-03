namespace PrimeFactors;

public class Sieve : PrimeGenerator {
  public IEnumerable<int> GetPrimesUpTo(int n) {
    List<int> primes = new();
    IEnumerable<int> candidates = GetCandidatesUpTo(n);
    if (candidates.Any()) {
      for (int first = candidates.First();
        first > 0 && first <= n;
        candidates = RemoveMultiplesOfFirst(candidates),
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

  public static IEnumerable<int> RemoveMultiplesOfFirst(IEnumerable<int> list) {
    int first = list.FirstOrDefault();
    return first == 0 ? list.Skip(1) : list.Where(element => element % first != 0);
  }
}
