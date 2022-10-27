def look_and_say(input_value: str) -> str:
    result = ''
    count = 1
    if len(input_value) == 2:
        current_digit = input_value[0]
        if current_digit == input_value[1]:
            count += 1
        else:
            result += f'{count}{current_digit}'
    result += f'{count}{input_value[-1]}'
    return result
