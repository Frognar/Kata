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
        return [int(n) for n in numbers.split(',')]

    @staticmethod
    def calculate_sum_of(numbers: List[int]) -> int:
        return sum(numbers)

