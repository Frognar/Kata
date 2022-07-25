namespace FizzBuzz.Tests;

public class RendererTests {
  int displayedCount = 0;
  readonly List<string> displayed = new();

  [Fact]
  public void ShowNumbers_ShouldShowAllNumbers() {
    Renderer renderer = new(TestDisplay);
    renderer.ShowNumbers(2, TestRender);
    Assert.Equal(2, displayedCount);
  }

  [Fact]
  public void ShowNumbers_ShouldRenderNumbers() {
    Renderer renderer = new(TestDisplay);
    renderer.ShowNumbers(1, TestRender);
    Assert.Equal("x1", displayed[0]);
  }

  [Fact]
  public void FizzBuzz_Test() {
    Renderer renderer = new(TestDisplay);
    renderer.ShowNumbers(100, FizzBuzz.Render);
    Assert.Equal("Fizz", displayed[2]);
    Assert.Equal("Buzz", displayed[4]);
    Assert.Equal("FizzBuzz", displayed[14]);
    Assert.Equal("98", displayed[97]);
    Assert.Equal("Fizz", displayed[98]);
    Assert.Equal("Buzz", displayed[99]);
  }

  void TestDisplay(string text) {
    displayedCount++;
    displayed.Add(text);
  }

  string TestRender(int number) => $"x{number}";
}