from re import split
from typing import List


class StringCalculator:
    @classmethod
    def add(cls, numbers: str) -> int:
        if not numbers:
            return 0
        numbers = cls.split_and_convert(numbers)
        return cls.calculate_sum_of(numbers)

    @staticmethod
    def split_and_convert(numbers: str) -> List[int]:
        default_delimiter = '[,\n]'
        return [int(n) for n in split(default_delimiter, numbers)]

    @staticmethod
    def calculate_sum_of(numbers: List[int]) -> int:
        return sum(numbers)
