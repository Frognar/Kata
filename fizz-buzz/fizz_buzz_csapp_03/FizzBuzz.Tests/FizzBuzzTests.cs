namespace FizzBuzz.Tests;

public class FizzBuzzTests {
  [Fact]
  public void FizzBuzz_Tests() {
    Assert.Equal("1", FizzBuzz.Render(1));
    Assert.Equal("2", FizzBuzz.Render(2));
  }
}