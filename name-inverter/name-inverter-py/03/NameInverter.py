import re
from typing import List


class NameInverter:
    @classmethod
    def invert(cls, name: str) -> str:
        name_parts = cls.break_into_parts_ignoring_whitespaces(name)
        if len(name_parts) < 2:
            return name_parts[0]
        return cls.invert_parts(cls.without_honorifics(name_parts))

    @classmethod
    def break_into_parts_ignoring_whitespaces(cls, name: str) -> List[str]:
        return re.split(RegularExpressions.any_amount_of_whitespaces(), name.strip())

    @classmethod
    def without_honorifics(cls, name_parts: List[str]) -> List[str]:
        if Honorifics.is_honorific(name_parts[0]):
            name_parts.pop(0)
        return name_parts

    @classmethod
    def invert_parts(cls, name_parts: List[str]) -> str:
        first = name_parts[0]
        last = name_parts[1]
        postnominals = cls.find_and_merge_postnominals(name_parts)
        return f'{last}, {first} {postnominals}'.strip()

    @classmethod
    def find_and_merge_postnominals(cls, name_parts) -> str:
        postnominals = ''
        for np in name_parts[2:]:
            postnominals += np + ' '
        return postnominals


class RegularExpressions:
    @classmethod
    def any_amount_of_whitespaces(cls) -> str:
        return '\\s+'


class Honorifics:
    known_honorifics = ['Mr.', 'Mrs.']

    @classmethod
    def is_honorific(cls, s: str) -> bool:
        return s in cls.known_honorifics
