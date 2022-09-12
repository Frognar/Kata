from typing import List


class NameInverter:
    @classmethod
    def invert(cls, name) -> str:
        name_parts = cls.break_into_parts(name)
        if len(name_parts) < 2:
            return name_parts[0]
        return cls.invert_parts(name_parts)

    @classmethod
    def break_into_parts(cls, name) -> List[str]:
        return name.strip().split(cls.space())

    @classmethod
    def space(cls) -> str:
        return ' '

    @classmethod
    def invert_parts(cls, name_parts) -> str:
        first = name_parts[0]
        last = name_parts[1]
        return f'{last}, {first}'
