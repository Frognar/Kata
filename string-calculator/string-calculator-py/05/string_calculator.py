from typing import Optional


class StringCalculator:
    @classmethod
    def add(cls, numbers: Optional[str]) -> int:
        if not numbers:
            return 0
        numbers = [int(n) for n in numbers.split(',')]
        return sum(numbers)
