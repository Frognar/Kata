from re import split


class NegativesNotAllowedError(RuntimeError):
    def __int__(self, message):
        super.__init__(message)


class StringCalculator:
    @classmethod
    def add(cls, numbers: str) -> int:
        if not numbers:
            return 0
        number_list = cls.split_and_convert_to_numbers(numbers)
        if any(n < 0 for n in number_list):
            raise NegativesNotAllowedError('negatives not allowed: -1')
        return sum(number_list)

    default_delimiters = '[,\n]'

    @classmethod
    def split_and_convert_to_numbers(cls, numbers: str):
        return [int(x) for x in split(cls.default_delimiters, numbers)]
