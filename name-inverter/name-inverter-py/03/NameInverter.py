import re
from typing import List


class NameInverter:
    @classmethod
    def invert(cls, name: str) -> str:
        name_parts = cls.break_into_parts(name)
        if len(name_parts) < 2:
            return name_parts[0]
        return cls.invert_parts(name_parts)

    @classmethod
    def break_into_parts(cls, name: str) -> List[str]:
        return re.split(cls.any_amount_of_whitespaces(), name.strip())

    @classmethod
    def any_amount_of_whitespaces(cls) -> str:
        return '\\s+'

    @classmethod
    def invert_parts(cls, name_parts: List[str]) -> str:
        first = name_parts[0]
        last = name_parts[1]
        return f'{last}, {first}'
