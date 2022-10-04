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
        numbers = cls.split_and_convert(numbers)
        cls.assert_not_contains_negatives(numbers)
        return cls.calculate_sum_of(numbers)

    @staticmethod
    def replace_custom_delimiter_with_comma(numbers: str) -> str:
        custom_delimiter_search = search('//(.+)\n', numbers)
        if custom_delimiter_search:
            custom_delimiters = custom_delimiter_search.group(1)
            custom_delimiters = custom_delimiters.replace('][', ' ')
            custom_delimiters = custom_delimiters.replace('[', '')
            custom_delimiters = custom_delimiters.replace(']', '')
            custom_delimiters = custom_delimiters.split(' ')
            numbers = numbers[custom_delimiter_search.end():]
            for delimiter in custom_delimiters:
                numbers = numbers.replace(delimiter, ',')
        return numbers

    @staticmethod
    def split_and_convert(numbers: str) -> List[int]:
        default_delimiter = '[,\n]'
        return [int(n) for n in split(default_delimiter, numbers)]

    @staticmethod
    def assert_not_contains_negatives(numbers: List[int]) -> None:
        negatives = [n for n in numbers if n < 0]
        if negatives:
            negatives_str = ','.join([str(n) for n in negatives])
            raise NegativesNotAllowedError(f'negatives not allowed: {negatives_str}')


    @staticmethod
    def calculate_sum_of(numbers: List[int]) -> int:
        return sum(numbers)

