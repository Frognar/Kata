namespace FizzBuzz.Tests;

public class RendererTests {
  int displayedCount = 0;
  readonly List<string> displayed = new();

  [Fact]
  public void ShowNumbers_DisplayAllNumbers() {
    Renderer renderer = new(Display);
    renderer.ShowNumbers(2, Render);
    Assert.Equal(2, displayedCount);
  }

  [Fact]
  public void ShowNumbers_RenderNumber() {
    Renderer renderer = new(Display);
    renderer.ShowNumbers(1, Render);
    Assert.Equal("o1", displayed[0]);
  }

  void Display(string text) {
    displayedCount++;
    displayed.Add(text);
  }

  string Render(int number) => $"o{number}";
}
