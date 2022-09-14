import re
from typing import List


class NameInverter:
    @classmethod
    def invert(cls, name: str) -> str:
        name_parts = cls.break_into_parts_ignoring_whitespaces(name)
        if len(name_parts) < 2:
            return name_parts[0]
        return cls.invert_parts(cls.without_honorifics(name_parts))

    @staticmethod
    def break_into_parts_ignoring_whitespaces(name: str) -> List[str]:
        return re.split(RegularExpressions.any_amount_of_whitespaces(), name.strip())

    @staticmethod
    def without_honorifics(name_parts: List[str]) -> List[str]:
        if Honorifics.is_honorifics(name_parts[0]):
            name_parts.pop(0)
        return name_parts

    @classmethod
    def invert_parts(cls, name_parts: List[str]) -> str:
        first = name_parts[0]
        last = name_parts[1]
        return f'{last}, {first}'


class RegularExpressions:
    @staticmethod
    def any_amount_of_whitespaces() -> str:
        return '\\s+'


class Honorifics:
    @staticmethod
    def is_honorifics(s: str) -> bool:
        known_honorifics = ['Mr.']
        return s in known_honorifics
