def look_and_say(input_value: str) -> str:
    if len(input_value) == 2:
        result = ''
        count = 2
        result += f'{count}{input_value[0]}'
        return result
    result = f'1{input_value}'
    return result
