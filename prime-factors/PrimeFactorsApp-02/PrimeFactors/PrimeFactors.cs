namespace PrimeFactors;

public class PrimeFactors {
   readonly PrimeGenerator generator;

  public PrimeFactors(PrimeGenerator generator) {
    this.generator = generator;
  }

  public IEnumerable<int> Of(int n) {
    List<int> primes = generator.GetPrimesUpTo(n).ToList();
    List<int> factors = new();
    for (int primeIndex = 0; n > 1; primeIndex++) {
      for (;  n % primes[primeIndex] == 0; n /= primes[primeIndex]) {
        factors.Add(primes[primeIndex]);
      }
    }

    return factors;
  }
}
