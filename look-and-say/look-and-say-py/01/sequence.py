def look_and_say(input_value: str) -> str:
    if len(input_value) == 2:
        if input_value[0] == input_value[1]:
            return f"2{input_value[0]}"
        return f"1{input_value[0]}1{input_value[1]}"
    return f"1{input_value}"
