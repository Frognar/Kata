
class StringCalculator:
    @classmethod
    def add(cls, numbers: str) -> int:
        if not numbers:
            return 0
        return int(numbers)
