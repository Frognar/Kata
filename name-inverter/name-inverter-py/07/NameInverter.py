class NameInverter:
    @classmethod
    def invert(cls, name: str) -> str:
        name_parts = name.strip().split(' ')
        first = name_parts[0]
        return f'{first}'
