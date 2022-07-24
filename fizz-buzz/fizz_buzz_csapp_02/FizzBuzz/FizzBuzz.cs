namespace FizzBuzz;

public class FizzBuzz {
  public string Render(int number) {
    string result = string.Empty;
    if (number == 3) {
      result = "Fizz";
    }

    if (number == 5) {
      result = "Buzz";
    }

    if (string.IsNullOrEmpty(result)) {
      result = number.ToString();
    }

    return result;
  }
}
