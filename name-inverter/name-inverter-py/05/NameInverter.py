class NameInverter:
    @classmethod
    def invert(cls, name: str) -> str:
        name_parts = name.strip().split(' ')
        if len(name_parts) < 2:
            return name_parts[0]
        first = name_parts[0]
        last = name_parts[1]
        return f'{last}, {first}'
