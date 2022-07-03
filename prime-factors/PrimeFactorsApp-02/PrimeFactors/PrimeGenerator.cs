namespace PrimeFactors;

public interface PrimeGenerator {
  IEnumerable<int> GetPrimesUpTo(int n);
}
