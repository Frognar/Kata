from re import split
from typing import List


class StringCalculator:
    @classmethod
    def add(cls, numbers: str) -> int:
        if not numbers:
            return 0
        number_list = [int(n) for n in split('[,\n]', numbers)]
        return cls.calculate_sum_of(number_list)

    @staticmethod
    def calculate_sum_of(numbers: List[int]) -> int:
        return sum(numbers)