namespace FizzBuzz.Tests;

public class RendererTests {
  int displayedCount = 0;

  [Fact]
  public void ShowNumbers_DisplayAllNumbers() {
    Renderer renderer = new(Display);
    renderer.ShowNumbers(2);
    Assert.Equal(2, displayedCount);
  }

  void Display(string text) {
    displayedCount++;
  }
}
