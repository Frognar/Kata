from re import split, search
from typing import Optional, List


class NegativesNotAllowedError(RuntimeError):
    def __int__(self, message):
        super.__init__(message)


class StringCalculator:
    @classmethod
    def add(cls, numbers: Optional[str]) -> int:
        if not numbers:
            return 0
        numbers = cls.replace_custom_delimiters_with_comma(numbers)
        numbers = cls.split_and_convert(numbers)
        cls.assert_not_contains_negatives(numbers)
        return cls.calculate_sum_of_numbers_less_than_or_equal_thousand(numbers)

    @classmethod
    def replace_custom_delimiters_with_comma(cls, numbers: str) -> str:
        custom_delimiter_search = search('//(.)\n|//\\[(.+)]\n', numbers)
        if custom_delimiter_search:
            numbers = numbers[custom_delimiter_search.end():]
            delimiter = custom_delimiter_search.group(1)
            if delimiter:
                numbers = numbers.replace(delimiter, ',')
            else:
                delimiters = cls.get_all_custom_delimiters(custom_delimiter_search.group(2))
                numbers = cls.replace_all_custom_delimiters_with_comma(numbers, delimiters)
        return numbers

    @staticmethod
    def get_all_custom_delimiters(delimiters_group: str) -> List[str]:
        delimiters = delimiters_group.replace('][', ' ')
        delimiters = delimiters.replace('[', '')
        delimiters = delimiters.replace(']', '')
        return sorted(delimiters.split(' '), key=len, reverse=True)

    @staticmethod
    def replace_all_custom_delimiters_with_comma(numbers: str, delimiters: List[str]):
        for delimiter in delimiters:
            numbers = numbers.replace(delimiter, ',')
        return numbers

    @staticmethod
    def assert_not_contains_negatives(numbers: List[int]) -> None:
        negatives = [n for n in numbers if n < 0]
        if negatives:
            negatives_str = ','.join([str(n) for n in negatives])
            raise NegativesNotAllowedError(f'negatives not allowed: {negatives_str}')

    @staticmethod
    def split_and_convert(numbers: str):
        return [int(n) for n in split('[,\n]', numbers)]

    @staticmethod
    def calculate_sum_of_numbers_less_than_or_equal_thousand(numbers: List[int]) -> int:
        return sum([n for n in numbers if n <= 1000])
