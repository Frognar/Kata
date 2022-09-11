import re


class NameInverter:
    @staticmethod
    def invert(name):
        name_parts = re.split('\\s+', name.strip())
        if len(name_parts) < 2:
            return name_parts[0]
        return NameInverter.invert_parts(name_parts)

    @staticmethod
    def invert_parts(name_parts):
        first = name_parts[0]
        last = name_parts[1]
        return f'{last}, {first}'
