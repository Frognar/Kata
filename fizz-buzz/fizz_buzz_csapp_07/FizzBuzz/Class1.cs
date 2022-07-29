﻿namespace FizzBuzz;

public class FizzBuzz {
  public string Render(int number) {
    string? result = null;
    if (number % 3 == 0) {
      result = "Fizz";
    }

    if (number == 5) {
      result = "Buzz";
    }

    result ??= number.ToString();
    return result;
  }
}
