def fizz_buzz(number) -> str:
    if number % 3 == 0:
        return "Fizz"
    if number == 5:
        return "Buzz"
    return str(number)
