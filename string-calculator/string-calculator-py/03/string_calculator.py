from re import split


class StringCalculator:
    @classmethod
    def add(cls, numbers: str) -> int:
        if not numbers:
            return 0
        default_delimiter = '[,\n]'
        return sum([int(n) for n in split(default_delimiter, numbers)])
