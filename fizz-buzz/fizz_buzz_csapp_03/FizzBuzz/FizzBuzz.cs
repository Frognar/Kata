namespace FizzBuzz;

public class FizzBuzz {
  public static string Render(int number) {
    string result = string.Empty;
    if (number == 3) {
      result += "Fizz";
    }

    if (string.IsNullOrEmpty(result)) {
      result = number.ToString();
    }

    return result;
  }
}
