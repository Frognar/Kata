class NameInverter:
    @staticmethod
    def invert(name):
        name_parts = name.strip().split(' ')
        if len(name_parts) < 2:
            return name_parts[0]
        first = name_parts[0]
        return f'{first}'
