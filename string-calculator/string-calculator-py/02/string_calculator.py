class StringCalculator:
    @classmethod
    def add(cls, numbers: str) -> int:
        if not numbers:
            return 0
        number_list = [int(n) for n in numbers.split(',')]
        return sum(number_list)
