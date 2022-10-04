from typing import List


class StringCalculator:
    @classmethod
    def add(cls, numbers: str) -> int:
        if not numbers:
            return 0
        numbers = [int(n) for n in numbers.split(',')]
        return cls.calculate_sum_of(numbers)

    @staticmethod
    def calculate_sum_of(numbers: List[int]) -> int:
        return sum(numbers)

