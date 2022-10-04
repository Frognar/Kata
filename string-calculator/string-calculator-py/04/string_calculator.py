class StringCalculator:
    @classmethod
    def add(cls, numbers: str) -> int:
        if not numbers:
            return 0
        return sum([int(n) for n in numbers.split(',')])
