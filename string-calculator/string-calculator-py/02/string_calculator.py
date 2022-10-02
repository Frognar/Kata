from re import split, search
from typing import List


class NegativesNotAllowedError(RuntimeError):
    def __int__(self, message):
        super.__init__(message)


class StringCalculator:
    @classmethod
    def add(cls, numbers: str) -> int:
        if not numbers:
            return 0
        numbers = cls.replace_custom_delimiter_with_comma(numbers)
        number_list = cls.split_and_convert_to_numbers(numbers)
        cls.assert_not_contains_negatives(number_list)
        return cls.calculate_sum_of(number_list)

    @staticmethod
    def replace_custom_delimiter_with_comma(numbers: str) -> str:
        custom_delimiter_search = search('(//(.)\n)|(//\\[(.+)]\n)', numbers)
        if custom_delimiter_search:
            custom_delimiter = custom_delimiter_search.group(2)
            if not custom_delimiter:
                custom_delimiter = custom_delimiter_search.group(4)
            numbers = numbers[custom_delimiter_search.end():]
            numbers = numbers.replace(custom_delimiter, ',')
        return numbers

    @staticmethod
    def split_and_convert_to_numbers(numbers: str) -> List[int]:
        default_delimiters = '[,\n]'
        return [int(n) for n in split(default_delimiters, numbers)]

    @staticmethod
    def assert_not_contains_negatives(numbers: List[int]) -> None:
        negatives = [n for n in numbers if n < 0]
        if negatives:
            negatives_str = ','.join([str(n) for n in negatives])
            raise NegativesNotAllowedError(f'negatives not allowed: {negatives_str}')

    @staticmethod
    def calculate_sum_of(numbers: List[int]) -> int:
        return sum(numbers)
