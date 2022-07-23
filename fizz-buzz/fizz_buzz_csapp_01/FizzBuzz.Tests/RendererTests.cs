namespace FizzBuzz.Tests;

public class RendererTests {
  int displayedCount = 0;

  [Fact]
  public void ShowNumbers_ShouldDisplayEachNumber() {
    Renderer renderer = new(TestDisplay);
    renderer.ShowNumbers(2);
    Assert.Equal(2, displayedCount);
  }

  void TestDisplay(string text) {
    displayedCount++;
  }
}