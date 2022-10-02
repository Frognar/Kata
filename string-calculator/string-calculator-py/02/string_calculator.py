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

    @classmethod
    def replace_custom_delimiter_with_comma(cls, numbers: str) -> str:
        custom_delimiter_search = search('//(.+)\n', numbers)
        if custom_delimiter_search:
            all_custom_delimiters = cls.find_all_custom_delimiters(custom_delimiter_search.group(1))
            numbers = numbers[custom_delimiter_search.end():]
            numbers = cls.replace_all_custom_delimiters_with_comma(numbers, all_custom_delimiters)
        return numbers

    @staticmethod
    def find_all_custom_delimiters(delimiters_group: str) -> List[str]:
        delimiters_group = delimiters_group.replace('][', ' ')
        delimiters_group = delimiters_group.replace('[', '')
        delimiters_group = delimiters_group.replace(']', '')
        return sorted(delimiters_group.split(' '), key=len, reverse=True)

    @staticmethod
    def replace_all_custom_delimiters_with_comma(numbers: str, custom_delimiters: List[str]) -> str:
        for custom_delimiter in custom_delimiters:
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
        return sum([n for n in numbers if n <= 1000])
