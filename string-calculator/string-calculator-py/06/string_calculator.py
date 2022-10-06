from re import split, search
from typing import Optional, List


class StringCalculator:
    @classmethod
    def add(cls, numbers: Optional[str]) -> int:
        if not numbers:
            return 0
        numbers = cls.replace_custom_delimiters_with_comma(numbers)
        numbers = cls.split_and_convert(numbers)
        return cls.calculate_sum_of(numbers)

    @classmethod
    def replace_custom_delimiters_with_comma(cls, numbers: str) -> str:
        single_delimiter_pattern = '//(.)\n'
        multiple_delimiter_pattern = '//\\[(.+)]\n'
        custom_delimiter_search = search(f'{single_delimiter_pattern}|{multiple_delimiter_pattern}', numbers)
        if custom_delimiter_search:
            numbers = numbers[custom_delimiter_search.end():]
            if not custom_delimiter_search.group(1):
                delimiters = cls.get_all_custom_delimiters(custom_delimiter_search.group(2))
                for delimiter in delimiters:
                    numbers = numbers.replace(delimiter, ',')
            else:
                delimiter = custom_delimiter_search.group(1)
                numbers = numbers.replace(delimiter, ',')
        return numbers

    @staticmethod
    def get_all_custom_delimiters(delimiters_group: str) -> List[str]:
        delimiters = delimiters_group.replace('][', ' ')
        delimiters = delimiters.replace('[', '')
        delimiters = delimiters.replace(']', '')
        return delimiters.split(' ')

    @staticmethod
    def split_and_convert(numbers: str):
        default_delimiters = '[,\n]'
        return [int(n) for n in split(default_delimiters, numbers)]

    @staticmethod
    def calculate_sum_of(numbers: List[int]):
        return sum(numbers)
