from typing import Optional, List
from re import split


class StringCalculator:
    @classmethod
    def add(cls, numbers: Optional[str]) -> int:
        if not numbers:
            return 0
        if numbers.startswith('//'):
            delimiter = numbers[2]
            numbers = numbers[4:]
            numbers = numbers.replace(delimiter, ',')
        numbers = cls.split_and_convert(numbers)
        return cls.calculate_sum_of(numbers)

    @staticmethod
    def split_and_convert(numbers: str) -> List[int]:
        return [int(n) for n in split('[,\n]', numbers)]

    @staticmethod
    def calculate_sum_of(numbers: List[int]):
        return sum(numbers)
