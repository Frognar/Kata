namespace FizzBuzz.Tests;

public class FizzBuzzTests {
  [Fact]
  public void FizzBuzz_Tests() {
    FizzBuzz fizzBuzz = new();
    Assert.Equal("1", fizzBuzz.Render(1));
    Assert.Equal("2", fizzBuzz.Render(2));
    Assert.Equal("Fizz", fizzBuzz.Render(3));
  }
}
