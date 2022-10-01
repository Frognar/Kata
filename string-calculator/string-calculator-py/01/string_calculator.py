from re import split
from typing import List


class NegativesNotAllowedError(RuntimeError):
    def __int__(self, message):
        super.__init__(message)


class StringCalculator:
    @classmethod
    def add(cls, numbers: str) -> int:
        if not numbers:
            return 0
        number_list = cls.split_and_convert_to_numbers(numbers)
        cls.assert_not_contains_negatives(number_list)
        return sum(number_list)

    default_delimiters = '[,\n]'

    @classmethod
    def split_and_convert_to_numbers(cls, numbers: str) -> List[int]:
        return [int(x) for x in split(cls.default_delimiters, numbers)]

    @classmethod
    def assert_not_contains_negatives(cls, numbers: List[int]) -> None:
        if any(n < 0 for n in numbers):
            raise NegativesNotAllowedError('negatives not allowed: -1')
