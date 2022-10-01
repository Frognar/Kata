from re import split


class StringCalculator:
    @classmethod
    def add(cls, numbers: str) -> int:
        if not numbers:
            return 0
        number_list = [int(x) for x in split('[,\n]', numbers)]
        sum_of_numbers = 0
        for number in number_list:
            sum_of_numbers += number
        return sum_of_numbers
