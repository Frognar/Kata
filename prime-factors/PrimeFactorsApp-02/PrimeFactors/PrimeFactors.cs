namespace PrimeFactors;

public class PrimeFactors {
   readonly PrimeGenerator generator;

  public PrimeFactors(PrimeGenerator generator) {
    this.generator = generator;
  }

  public IEnumerable<int> Of(int n) {
    List<int> primes = generator.GetPrimesUpTo(n).ToList();
    int primeIndex = 0;
    List<int> factors = new();
    while (n > 1) {
      if (n % primes[primeIndex] == 0) {
        factors.Add(n);
        n /= primes[primeIndex];
      }
      else {
        primeIndex++;
      }
    }

    return factors;
  }
}
