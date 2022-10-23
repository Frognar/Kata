def look_and_say(input_value: str) -> str:
    result = ''
    count = 1
    if len(input_value) > 1:
        current_digit = input_value[0]
        next_digit = input_value[1]
        if current_digit == next_digit:
            count += 1
        else:
            result += say(count, current_digit)
    last_digit = input_value[-1]
    result += say(count, last_digit)
    return result


def say(count: int, digit: str) -> str:
    return f'{count}{digit}'
