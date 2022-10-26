def look_and_say(input_value: str) -> str:
    result = ''
    count = 1
    index = 0
    if len(input_value) == 2:
        current_digit = input_value[index]
        next_digit = input_value[1]
        if current_digit == next_digit:
            count += 1
        else:
            result += f'{count}{current_digit}'
    last_digit = input_value[-1]
    result += f'{count}{last_digit}'
    return result
