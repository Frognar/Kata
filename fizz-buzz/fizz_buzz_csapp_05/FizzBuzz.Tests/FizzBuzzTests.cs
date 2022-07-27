namespace FizzBuzz.Tests;

public class FizzBuzzTests {
  [Fact]
  public void FizzBuzz_Test() {
    Assert.Equal("1", FizzBuzz.Render(1));
    Assert.Equal("2", FizzBuzz.Render(2));
    Assert.Equal("Fizz", FizzBuzz.Render(3));
    Assert.Equal("4", FizzBuzz.Render(4));
    Assert.Equal("Buzz", FizzBuzz.Render(5));
  }
}