def look_and_say(input_value: str) -> str:
    result = ""
    count = 1
    for index in range(0, len(input_value) - 1):
        current_digit = input_value[index]
        next_digit = input_value[index + 1]
        if current_digit == next_digit:
            count += 1
        else:
            result += say(count, current_digit)
            count = 1
    last_digit = input_value[-1]
    result += say(count, last_digit)
    return result


def say(count: int, digit: str):
    return f'{count}{digit}'


def look_and_say_sequence(start: str, depth: int) -> str:
    result = start
    current = start
    while depth > 0:
        current = look_and_say(current)
        result += f' -> {current}'
        depth -= 1
    return result

