namespace PrimeFactors;

public class Sieve : PrimeGenerator {
  public IEnumerable<int> GetPrimesUpTo(int n)
    => throw new NotImplementedException();
  public IEnumerable<int> RemoveMultiplesOfFirst(IEnumerable<int> list) {
    int first = list.FirstOrDefault();
    if (first == 0) {
      return list.Skip(1);
    }

    return list.Where(element => element % first != 0);
  }
}
