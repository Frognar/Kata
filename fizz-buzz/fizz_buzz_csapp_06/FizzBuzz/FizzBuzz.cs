namespace FizzBuzz;

public class FizzBuzz {
  public static string Render(int number) {
    string? result = null;
    if (number == 3) {
      result = "Fizz";
    }

    if (number == 5) {
      result = "Buzz";
    }

    result ??= number.ToString();
    return result;
  }
}
