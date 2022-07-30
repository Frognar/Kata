class FizzBuzz:
    def render(self, number):
        result = None
        if number == 3:
            result = "Fizz"

        if result is None:
            result = str(number)

        return result
