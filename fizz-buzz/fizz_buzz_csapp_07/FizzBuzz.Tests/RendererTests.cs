namespace FizzBuzz.Tests;

public class RendererTests {
  int displayedCount = 0;
  readonly List<string> displayed = new();

  [Fact]
  public void ShowNumbers_DisplayAllNumbers() {
    Renderer renderer = new(Display);
    renderer.ShowNumbers(3, Render);
    Assert.Equal(3, displayedCount);
  }

  [Fact]
  public void ShowNumbers_RenderNumber() {
    Renderer renderer = new(Display);
    renderer.ShowNumbers(1, Render);
    Assert.Equal("_1", displayed[0]);
  }

  [Fact]
  public void FizzBuzz_FinalTest() {
    Renderer renderer = new(Display);
    renderer.ShowNumbers(100, FizzBuzz.Render);
    Assert.Equal("Fizz", displayed[2]);
    Assert.Equal("Buzz", displayed[4]);
    Assert.Equal("FizzBuzz", displayed[14]);
    Assert.Equal("16", displayed[15]);
    Assert.Equal("FizzBuzz", displayed[44]);
    Assert.Equal("Buzz", displayed[49]);
    Assert.Equal("Fizz", displayed[98]);
  }

  void Display(string text) {
    displayedCount++;
    displayed.Add(text);
  }

  string Render(int number) => $"_{number}";
}