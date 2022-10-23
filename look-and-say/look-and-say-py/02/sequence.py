def look_and_say(input_value: str) -> str:
    count = 1
    result = ''
    if len(input_value) == 2:
        if input_value[0] == input_value[1]:
            count += 1
            result += f'{count}{input_value[0]}'
            return result
        result += f'{count}{input_value[0]}'
        result += f'{count}{input_value[1]}'
        return result
    result += f'{count}{input_value}'
    return result
