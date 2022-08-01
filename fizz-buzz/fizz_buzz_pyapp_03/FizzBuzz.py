def fizz_buzz(number):
    result = str(number)
    if number % 3 == 0:
        result = 'Fizz'
    if number % 5 == 0:
        result = 'Buzz'
    return result
