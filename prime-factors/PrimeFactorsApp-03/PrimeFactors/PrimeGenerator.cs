namespace PrimeFactors;

public interface PrimeGenerator {
  public IEnumerable<long> GetPrimesUpTo(long n);
}
