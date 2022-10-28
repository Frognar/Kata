def look_and_say(input_value: str) -> str:
    result = ''
    if len(input_value) == 2:
        count = 1
        count += 1
        result += f'{count}{input_value[0]}'
        return result
    count = 1
    result += f'{count}{input_value}'
    return result
