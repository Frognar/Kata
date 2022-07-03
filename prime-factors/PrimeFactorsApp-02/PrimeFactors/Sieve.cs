namespace PrimeFactors;

public class Sieve : PrimeGenerator {
  public IEnumerable<int> GetPrimesUpTo(int n)
    => throw new NotImplementedException();
  public IEnumerable<int> RemoveMultiplesOfFirst(IEnumerable<int> list) {
    if (list.Any()) {
      return list.Where(element => element % list.First() != 0);
    }
    
    return new List<int>();
  }
}
