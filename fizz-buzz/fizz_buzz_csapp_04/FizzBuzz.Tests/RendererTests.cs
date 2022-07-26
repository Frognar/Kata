namespace FizzBuzz.Tests;

public class RendererTests {
  int displayedCount = 0;

  [Fact]
  public void ShowNumbers_ShouldShowAllNumbers() {
    Renderer renderer = new(TestDisplay);
    renderer.ShowNumbers(2);
    Assert.Equal(2, displayedCount);
  }

  void TestDisplay(string txt) {
    displayedCount++;
  }
}