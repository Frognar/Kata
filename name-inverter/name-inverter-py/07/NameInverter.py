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
        if Honorifics.is_honorific(name_parts[0]):
            name_parts.pop(0)
        return name_parts

    @classmethod
    def invert_parts(cls, name_parts: List[str]) -> str:
        first = name_parts[0]
        last = name_parts[1]
        postnominals = ''
        if len(name_parts) > 2:
            postnominals = name_parts[2]
        return f'{last}, {first} {postnominals}'.strip()


class RegularExpressions:
    @staticmethod
    def any_amount_of_whitespaces():
        return '\\s+'


class Honorifics:
    known_honorifics = ['Mr.', 'Mrs.']

    @classmethod
    def is_honorific(cls, s: str) -> bool:
        return s in cls.known_honorifics
