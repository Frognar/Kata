from re import split
from typing import Optional


class StringCalculator:
    @classmethod
    def add(cls, numbers: Optional[str]) -> int:
        if not numbers:
            return 0
        if numbers.startswith('//'):
            delimiter = numbers[2]
            numbers = numbers[4:]
            numbers = numbers.replace(delimiter, ',')
        return sum(cls.split_and_convert(numbers))

    @staticmethod
    def split_and_convert(numbers: str):
        return [int(n) for n in split('[,\n]', numbers)]
