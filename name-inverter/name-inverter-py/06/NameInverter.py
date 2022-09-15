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
        postnominals = cls.find_and_merge_postnominals(name_parts)
        return f'{last}, {first} {postnominals}'.strip()

    @staticmethod
    def find_and_merge_postnominals(name_parts: List[str]) -> str:
        postnominals = ''
        for np in name_parts[2:]:
            postnominals += np + ' '
        return postnominals


class RegularExpressions:
    @staticmethod
    def any_amount_of_whitespaces() -> str:
        return '\\s+'


class Honorifics:
    known_honorifics = ['Mr.', 'Mrs.']

    @classmethod
    def is_honorific(cls, s) -> bool:
        return s in cls.known_honorifics
