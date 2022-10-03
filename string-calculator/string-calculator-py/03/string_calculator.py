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
        numbers = cls.split_and_convert(numbers)
        if any(n < 0 for n in numbers):
            raise NegativesNotAllowedError('negatives not allowed: -1')
        return cls.calculate_sum_of(numbers)

    @staticmethod
    def split_and_convert(numbers: str) -> List[int]:
        default_delimiter = '[,\n]'
        return [int(n) for n in split(default_delimiter, numbers)]

    @staticmethod
    def calculate_sum_of(numbers: List[int]) -> int:
        return sum(numbers)
