namespace FizzBuzz.Tests;

public class RendererTests {
  int displayedCount = 0;
  readonly List<string> displayed = new();


  [Fact]
  public void ShowNumbers_ShouldDisplayEachNumber() {
    Renderer renderer = new(TestDisplay);
    renderer.ShowNumbers(2, TestRender);
    Assert.Equal(2, displayedCount);
  }


  [Fact]
  public void ShowNumber_ShouldRenderNumbers() {
    Renderer renderer = new(TestDisplay);
    renderer.ShowNumbers(1, TestRender);
    Assert.Equal("x1", displayed[0]);
  }

  [Fact]
  public void FizzBuzz_Test() {
    FizzBuzz fizzBuzz = new();
    Renderer renderer = new(TestDisplay);
    renderer.ShowNumbers(100, fizzBuzz.Render);
    Assert.Equal("1", displayed[0]);
    Assert.Equal("2", displayed[1]);
    Assert.Equal("Fizz", displayed[2]);
    Assert.Equal("4", displayed[3]);
    Assert.Equal("Buzz", displayed[4]);
    Assert.Equal("Fizz", displayed[5]);
    Assert.Equal("FizzBuzz", displayed[14]);
    Assert.Equal("Buzz", displayed[99]);
  }

  void TestDisplay(string text) {
    displayedCount++;
    displayed.Add(text);
  }

  string TestRender(int number) => "x" + number.ToString();
}