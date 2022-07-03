namespace PrimeFactors;

public class Sieve : PrimeGenerator {
  public IEnumerable<int> GetPrimesUpTo(int n)
    => throw new NotImplementedException();
  public IEnumerable<int> RemoveMultiplesOfFirst(List<int> list) {
    if (list.Count == 0) {
      return new List<int>();
    }

    return list.Where(element => element % list.First() != 0);
  }
}
