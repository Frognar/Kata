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
        if any(n < 0 for n in number_list):
            raise NegativesNotAllowedError('negatives not allowed: -4')
        return cls.calculate_sum_of(number_list)

    @staticmethod
    def split_and_convert_to_numbers(numbers):
        default_delimiters = '[,\n]'
        return [int(n) for n in split(default_delimiters, numbers)]

    @staticmethod
    def calculate_sum_of(numbers: List[int]) -> int:
        return sum(numbers)
