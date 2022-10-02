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
        return cls.calculate_sum_of(number_list)

    @staticmethod
    def split_and_convert_to_numbers(numbers: str) -> List[int]:
        default_delimiters = '[,\n]'
        return [int(n) for n in split(default_delimiters, numbers)]

    @staticmethod
    def assert_not_contains_negatives(numbers: List[int]) -> None:
        negatives = [n for n in numbers if n < 0]
        if negatives:
            raise NegativesNotAllowedError('negatives not allowed: -4')

    @staticmethod
    def calculate_sum_of(numbers: List[int]) -> int:
        return sum(numbers)
