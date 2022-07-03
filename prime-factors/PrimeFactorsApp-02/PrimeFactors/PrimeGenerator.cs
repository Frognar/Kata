namespace PrimeFactors;

public interface PrimeGenerator {
  IEnumerable<long> GetPrimesUpTo(long n);
}
