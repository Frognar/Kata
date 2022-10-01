from re import split


class StringCalculator:
    @classmethod
    def add(cls, numbers: str) -> int:
        if not numbers:
            return 0
        number_list = cls.split_and_convert_to_numbers(numbers)
        return sum(number_list)

    @classmethod
    def split_and_convert_to_numbers(cls, numbers: str):
        return [int(x) for x in split('[,\n]', numbers)]