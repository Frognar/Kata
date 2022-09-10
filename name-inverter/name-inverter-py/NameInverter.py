import re


def invert(name):
    name_parts = break_into_parts_ignoring_whitespaces(name)
    if len(name_parts) < 2:
        return name_parts[0]
    return invert_parts(name_parts)


def break_into_parts_ignoring_whitespaces(name):
    return re.split(any_amount_of_whitespaces(), name.strip())


def any_amount_of_whitespaces():
    return '\\s+'


def invert_parts(name_parts):
    print(name_parts)
    first = name_parts[0]
    last = name_parts[1]
    return f'{last}, {first}'
