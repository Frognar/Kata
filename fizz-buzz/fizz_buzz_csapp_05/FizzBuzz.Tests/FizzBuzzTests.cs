namespace FizzBuzz.Tests;

public class FizzBuzzTests {
  [Fact]
  public void FizzBuzz_Test() {
    FizzBuzz fizzBuzz = new();
    Assert.Equal("1", fizzBuzz.Render(1));
    Assert.Equal("2", fizzBuzz.Render(2));
  }
}