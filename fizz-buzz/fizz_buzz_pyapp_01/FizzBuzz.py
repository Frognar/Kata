class FizzBuzz:
    def render(self, number):
        result = None
        if number % 3 == 0:
            result = "Fizz"

        if number == 5:
            result = "Buzz"

        if result is None:
            result = str(number)

        return result
