namespace FizzBuzz.Tests;

public class RendererTests {
  int displayedCount = 0;
  readonly List<string> displayed = new();

  [Fact]
  public void ShowNumbers_ShouldDisplayAllNumbers() {
    Renderer renderer = new(TestDisplay);
    renderer.ShowNumbers(2, TestRender);
    Assert.Equal(2, displayedCount);
  }

  [Fact]
  public void ShowNumbers_ShouldRenderNumber() {
    Renderer renderer = new(TestDisplay);
    renderer.ShowNumbers(1, TestRender);
    Assert.Equal("x1", displayed[0]);
  }

  void TestDisplay(string text) {
    displayedCount++;
    displayed.Add(text);
  }

  string TestRender(int number) => $"x{number}";
}