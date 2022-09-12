class NameInverter:
    @classmethod
    def invert(cls, name):
        name_parts = cls.break_into_parts(name)
        if len(name_parts) < 2:
            return name_parts[0]
        first = name_parts[0]
        last = name_parts[1]
        return f'{last}, {first}'

    @classmethod
    def break_into_parts(cls, name):
        return name.strip().split(cls.space())

    @classmethod
    def space(cls):
        return ' '
