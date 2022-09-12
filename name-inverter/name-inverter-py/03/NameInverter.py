class NameInverter:
    @classmethod
    def invert(cls, name):
        name_parts = name.strip().split(' ')
        first = name_parts[0]
        return f'{first}'
