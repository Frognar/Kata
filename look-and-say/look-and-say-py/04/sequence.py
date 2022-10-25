def look_and_say(input_value: str) -> str:
    result = ''
    count = 1
    index = 0
    if len(input_value) > 1:
        if input_value[index] == input_value[index + 1]:
            count += 1
        else:
            result += f'{count}{input_value[index]}'
    result += f'{count}{input_value[-1]}'
    return result
