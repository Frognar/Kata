def look_and_say(input_value: str) -> str:
    result = ''
    count = 1
    for index in range(len(input_value) - 1):
        if input_value[index] == input_value[index + 1]:
            count += 1
        else:
            result += say(count, input_value[index])
            count = 1
    result += say(count, input_value[-1])
    return result


def say(count: int, digit: str) -> str:
    return f'{count}{digit}'
