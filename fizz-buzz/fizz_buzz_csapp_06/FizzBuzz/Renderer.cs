namespace FizzBuzz;

public class Renderer {
  readonly Action<string> display;

  public Renderer(Action<string> display) {
    this.display = display;
  }

  public void ShowNumbers(int count) {
    for (int i = 0; i < count; i++) {
      display("txt");
    }
  }
}
