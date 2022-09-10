import re


def invert(name):
    name_parts = re.split(any_amount_of_whitespaces(), name.strip())
    if len(name_parts) < 2:
        return name_parts[0]
    first = name_parts[0]
    last = name_parts[1]
    return f'{last}, {first}'


def any_amount_of_whitespaces():
    return '\\s+'
