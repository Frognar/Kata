def look_and_say(input_value: str) -> str:
    result = ''
    count = 1
    for index in range(len(input_value) - 1):
        current_digit = input_value[index]
        if current_digit == input_value[index + 1]:
            count += 1
        else:
            result += say(count, input_value[index])
            count = 1
    last_digit = input_value[-1]
    result += say(count, last_digit)
    return result


def say(count: int, digit: str) -> str:
    return f'{count}{digit}'
