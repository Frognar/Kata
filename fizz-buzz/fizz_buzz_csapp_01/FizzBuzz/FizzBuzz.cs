﻿namespace FizzBuzz;

public class FizzBuzz {
  public string Render(int number) {
    if (number == 3) {
      return "Fizz";
    }

    if (number == 5) {
      return "Buzz";
    }

    return number.ToString();
  }
}
