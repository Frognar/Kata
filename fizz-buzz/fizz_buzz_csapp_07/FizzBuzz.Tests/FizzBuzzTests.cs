namespace FizzBuzz.Tests;

public class FizzBuzzTests {
  [Fact]
  public void FizzBuzz_Tests() {
    FizzBuzz fizzBuzz = new();
    Assert.Equal("1", fizzBuzz.Render(1));
    Assert.Equal("2", fizzBuzz.Render(2));
    Assert.Equal("Fizz", fizzBuzz.Render(3));
    Assert.Equal("4", fizzBuzz.Render(4));
    Assert.Equal("Buzz", fizzBuzz.Render(5));
    Assert.Equal("Fizz", fizzBuzz.Render(6));
    Assert.Equal("Buzz", fizzBuzz.Render(10));
    Assert.Equal("FizzBuzz", fizzBuzz.Render(15));
  }
}
