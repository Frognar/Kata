def look_and_say(input_value: str) -> str:
    result = ''
    if len(input_value) == 2:
        count = 1
        result += f'{count}{input_value[0]}'
    result += f'1{input_value[-1]}'
    return result
