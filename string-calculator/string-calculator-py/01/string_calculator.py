from re import split


class StringCalculator:
    @classmethod
    def add(cls, numbers: str) -> int:
        if not numbers:
            return 0
        number_list = [int(x) for x in split('[,\n]', numbers)]
        return sum(number_list)
