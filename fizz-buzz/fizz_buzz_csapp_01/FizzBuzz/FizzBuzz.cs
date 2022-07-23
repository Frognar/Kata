namespace FizzBuzz;

public class FizzBuzz {
  public string Render(int number) {
    if (number == 3) {
      return "Fizz";
    }

    return number.ToString();
  }
}
