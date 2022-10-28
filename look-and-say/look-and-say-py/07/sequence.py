def look_and_say(input_value: str) -> str:
    if len(input_value) == 2:
        result = ''
        count = 2
        result += f'{count}{input_value[0]}'
        return result
    result = ''
    count = 1
    result += f'{count}{input_value}'
    return result
