namespace FizzBuzz;

public class Renderer {
  readonly Action<string> display;

  public Renderer(Action<string> testDisplay) {
    display = testDisplay;
  }

  public void ShowNumbers(int count) {
    for (int i = 1; i <= count; i++) {
      display("txt");
    }
  }
}