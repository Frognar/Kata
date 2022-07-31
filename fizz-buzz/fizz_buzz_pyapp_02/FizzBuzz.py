def fizz_buzz(number) -> str:
    result = ""
    if number % 3 == 0:
        result += "Fizz"
    if number % 5 == 0:
        result += "Buzz"
    if result == "":
        result = str(number)
    return result
