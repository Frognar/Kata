namespace PrimeFactors;

public class Sieve : PrimeGenerator {
  public IEnumerable<int> GetPrimesUpTo(int n) {
    HashSet<int> noPrimes = GetNoPrimesUpTo(n);
    for (int i = 2; i <= n; i++) {
      if (noPrimes.Contains(i) == false) {
        yield return i;
      }
    }
  }

  static HashSet<int> GetNoPrimesUpTo(int n) {
    HashSet<int> noPrimes = new();
    for (int i = 2; i <= n; i++) {
      for (int j = i * 2; j <= n; j += i) {
        if (noPrimes.Contains(j) == false) {
          noPrimes.Add(j);
        }
      }
    }

    return noPrimes;
  }
}
