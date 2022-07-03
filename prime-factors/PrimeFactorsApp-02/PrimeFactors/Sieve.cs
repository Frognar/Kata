namespace PrimeFactors;

public class Sieve : PrimeGenerator {
  public IEnumerable<int> GetPrimesUpTo(int n) {
    return new List<int>();
  }

  public static IEnumerable<int> RemoveMultiplesOfFirst(IEnumerable<int> list) {
    int first = list.FirstOrDefault();
    return first == 0 ? list.Skip(1) : list.Where(element => element % first != 0);
  }
}
