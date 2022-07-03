namespace PrimeFactors;

public class Sieve : PrimeGenerator {
  public IEnumerable<int> GetPrimesUpTo(int n) {
    List<int> candidates = new();
    for(int i = 2; i <= n; i++) {
      candidates.Add(i);
    }

    List<int> primes = new();
    int first = candidates.FirstOrDefault();
    while (first > 0 && first <= n) {
      primes.Add(first);
      candidates = RemoveMultiplesOfFirst(candidates).ToList();
      first = candidates.FirstOrDefault();
    }

    return primes;
  }

  public static IEnumerable<int> RemoveMultiplesOfFirst(IEnumerable<int> list) {
    int first = list.FirstOrDefault();
    return first == 0 ? list.Skip(1) : list.Where(element => element % first != 0);
  }
}
