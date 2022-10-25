def look_and_say(input_value: str) -> str:
    result = ''
    count = 1
    if len(input_value) == 2:
        count += 1
    result += f'{count}{input_value[-1]}'
    return result
