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
        numbers = cls.replace_custom_delimiters_with_comma(numbers)
        number_list = cls.split_and_convert_to_numbers(numbers)
        cls.assert_not_contains_negatives(number_list)
        return sum(number_list)

    @classmethod
    def replace_custom_delimiters_with_comma(cls, numbers: str) -> str:
        custom_delimiter_search = search('//(.+)\n', numbers)
        if custom_delimiter_search:
            custom_delimiter_group = custom_delimiter_search.group(1).replace(' ', '')
            custom_delimiter_group = custom_delimiter_group.replace('][', ' ')
            custom_delimiter_group = custom_delimiter_group.replace('[', '')
            custom_delimiter_group = custom_delimiter_group.replace(']', '')
            all_custom_delimiters = custom_delimiter_group.split(' ')
            numbers = numbers[custom_delimiter_search.end():]
            for custom_delimiter in all_custom_delimiters:
                numbers = numbers.replace(custom_delimiter, ',')
        return numbers

    default_delimiters = '[,\n]'

    @classmethod
    def split_and_convert_to_numbers(cls, numbers: str) -> List[int]:
        return [int(x) for x in split(cls.default_delimiters, numbers)]

    @classmethod
    def assert_not_contains_negatives(cls, numbers: List[int]) -> None:
        negatives = [n for n in numbers if n < 0]
        if negatives:
            negatives_str = ','.join([str(n) for n in negatives])
            raise NegativesNotAllowedError(f'negatives not allowed: {negatives_str}')
