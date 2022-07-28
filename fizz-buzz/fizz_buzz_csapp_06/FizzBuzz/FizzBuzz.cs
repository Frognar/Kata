namespace FizzBuzz;

public class FizzBuzz {
  public static string Render(int number) {
    string? result = null;
    if (number % 3 == 0) {
      result += "Fizz";
    }

    if (number % 5 == 0) {
      result += "Buzz";
    }

    result ??= number.ToString();
    return result;
  }
}
