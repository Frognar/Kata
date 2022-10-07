from typing import Optional


class StringCalculator:
    @classmethod
    def add(cls, numbers: Optional[str]) -> int:
        if not numbers:
            return 0
        return sum(cls.split_and_convert(numbers))

    @staticmethod
    def split_and_convert(numbers: str):
        return [int(n) for n in numbers.split(',')]
