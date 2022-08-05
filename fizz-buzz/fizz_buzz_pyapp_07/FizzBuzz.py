def fizz_buzz(number):
    result = ''
    if number % 3 == 0:
        result = "Fizz"
    if number == 5:
        result = "Buzz"
    if result == '':
        result = str(number)
    return result
