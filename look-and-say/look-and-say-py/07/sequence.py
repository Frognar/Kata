def look_and_say(input_value: str) -> str:
    result = ''
    count = 1
    if len(input_value) == 2:
        current_digit = input_value[0]
        next_digit = input_value[1]
        if current_digit == next_digit:
            count += 1
        else:
            result += say(count, current_digit)
    result += say(count, input_value[-1])
    return result


def say(count: int, digit: str) -> str:
    return f'{count}{digit}'
