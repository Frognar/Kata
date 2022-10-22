def look_and_say(input_value: str) -> str:
    result = ""
    if len(input_value) == 2:
        if input_value[0] == input_value[1]:
            result += f"2{input_value[0]}"
            return result
        result += f"1{input_value[0]}"
        result += f"1{input_value[1]}"
        return result
    result = ""
    result += f"1{input_value}"
    return result
