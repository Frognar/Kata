import re


class NameInverter:
    @staticmethod
    def invert(name):
        name_parts = NameInverter.break_into_parts_ignoring_whitespaces(name)
        if len(name_parts) < 2:
            return name_parts[0]
        return NameInverter.invert_parts(NameInverter.without_honorifics(name_parts))

    @staticmethod
    def break_into_parts_ignoring_whitespaces(name):
        return re.split(RegularExpressions.any_amount_of_whitespaces(), name.strip())

    @staticmethod
    def without_honorifics(name_parts):
        if Honorifics.is_honorific(name_parts[0]):
            name_parts.pop(0)
        return name_parts

    @staticmethod
    def invert_parts(name_parts):
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

    @staticmethod
    def is_honorific(s):
        return s in Honorifics.known_honorifics
