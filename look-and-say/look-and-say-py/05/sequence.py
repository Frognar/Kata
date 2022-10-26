def look_and_say(input_value: str) -> str:
    result = ''
    count = 1
    for index in range(len(input_value) - 1):
        if len(input_value) > 1:
            current_digit = input_value[index]
            next_digit = input_value[index + 1]
            if current_digit == next_digit:
                count += 1
            else:
                result += f'{count}{current_digit}'
    last_digit = input_value[-1]
    result += f'{count}{last_digit}'
    return result
