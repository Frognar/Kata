def look_and_say(input_value: str) -> str:
    count = 1
    if len(input_value) == 2:
        count += 1
        return f'{count}{input_value[-1]}'
    count = 1
    return f'{count}{input_value[-1]}'
