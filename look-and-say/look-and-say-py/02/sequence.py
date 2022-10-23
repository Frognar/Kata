def look_and_say(input_value: str) -> str:
    count = 1
    result = ''
    if len(input_value) == 2:
        current_digit = input_value[0]
        next_digit = input_value[1]
        if current_digit == next_digit:
            count += 1
        else:
            result += f'{count}{current_digit}'
    result += f'{count}{input_value[-1]}'
    return result
