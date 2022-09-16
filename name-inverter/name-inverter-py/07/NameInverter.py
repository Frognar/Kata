import re
from typing import List


class NameInverter:
    @classmethod
    def invert(cls, name: str) -> str:
        name_parts = cls.break_into_parts_ignoring_whitespaces(name)
        if len(name_parts) < 2:
            return name_parts[0]
        return cls.invert_parts(name_parts)

    @staticmethod
    def break_into_parts_ignoring_whitespaces(name: str) -> List[str]:
        return re.split('\\s+', name.strip())

    @classmethod
    def invert_parts(cls, name_parts: List[str]) -> str:
        first = name_parts[0]
        last = name_parts[1]
        return f'{last}, {first}'
