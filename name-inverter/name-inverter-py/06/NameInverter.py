from typing import List


class NameInverter:
    @classmethod
    def invert(cls, name: str) -> str:
        name_parts = cls.break_into_parts(name)
        if len(name_parts) < 2:
            return name_parts[0]
        return cls.invert_parts(name_parts)

    @staticmethod
    def break_into_parts(name: str) -> List[str]:
        return name.strip().split(' ')

    @classmethod
    def invert_parts(cls, name_parts: List[str]) -> str:
        first = name_parts[0]
        last = name_parts[1]
        return f'{last}, {first}'
