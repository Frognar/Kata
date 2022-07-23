﻿namespace FizzBuzz;

public class Renderer {
  readonly Action<string> display;

  public Renderer(Action<string> testDisplay) {
    display = testDisplay;
  }

  public void ShowNumbers(int count, Func<int, string> render) {
    for (int i = 1; i <= count; i++) {
      display(render(i));
    }
  }
}