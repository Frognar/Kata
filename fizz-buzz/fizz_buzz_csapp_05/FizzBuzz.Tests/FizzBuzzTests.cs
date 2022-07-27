namespace FizzBuzz.Tests;

public class FizzBuzzTests {
  [Fact]
  public void FizzBuzz_Test() {
    Assert.Equal("1", FizzBuzz.Render(1));
    Assert.Equal("2", FizzBuzz.Render(2));
    Assert.Equal("Fizz", FizzBuzz.Render(3));
  }
}