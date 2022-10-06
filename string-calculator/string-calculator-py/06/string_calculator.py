from typing import Optional


class StringCalculator:
    @classmethod
    def add(cls, numbers: Optional[str]) -> int:
        if not numbers:
            return 0
        numbers = cls.split_and_convert(numbers)
        return sum(numbers)

    @staticmethod
    def split_and_convert(numbers: str):
        return [int(n) for n in numbers.split(',')]
