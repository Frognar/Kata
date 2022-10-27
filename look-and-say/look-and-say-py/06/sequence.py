def look_and_say(input_value: str) -> str:
    result = ''
    count = 1
    if len(input_value) == 2:
        result += f'{count}{input_value[0]}'
    result += f'{count}{input_value[-1]}'
    return result
