from re import split, search
from typing import Optional


class StringCalculator:
    @classmethod
    def add(cls, numbers: Optional[str]) -> int:
        if not numbers:
            return 0
        numbers = cls.replace_custom_delimiters_with_comma(numbers)
        return sum(cls.split_and_convert(numbers))

    @staticmethod
    def replace_custom_delimiters_with_comma(numbers: str) -> str:
        custom_delimiter_search = search('//(.)\n|//\\[(.+)]\n', numbers)
        if custom_delimiter_search:
            numbers = numbers[custom_delimiter_search.end():]
            delimiter = custom_delimiter_search.group(1)
            if delimiter:
                numbers = numbers.replace(delimiter, ',')
            else:
                delimiters = custom_delimiter_search.group(2)
                delimiters = delimiters.replace('][', ' ')
                delimiters = delimiters.replace('[', '')
                delimiters = delimiters.replace(']', '')
                delimiters = delimiters.split(' ')
                for delimiter in delimiters:
                    numbers = numbers.replace(delimiter, ',')
        return numbers

    @staticmethod
    def split_and_convert(numbers: str):
        return [int(n) for n in split('[,\n]', numbers)]
