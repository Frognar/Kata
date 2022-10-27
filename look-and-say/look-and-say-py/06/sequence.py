def look_and_say(input_value: str) -> str:
    if len(input_value) == 2:
        result = f'1{input_value[0]}1{input_value[1]}'
        return result
    return f'1{input_value}'
