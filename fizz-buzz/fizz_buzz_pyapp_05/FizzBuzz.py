def fizz_buzz(number) -> str:
    result = str(number)
    if number % 3 == 0:
        result = 'Fizz'
    if number == 5:
        result = 'Buzz'
    return result
