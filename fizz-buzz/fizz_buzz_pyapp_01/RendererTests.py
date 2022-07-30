import unittest

from FizzBuzz import fizz_buzz
from Renderer import Renderer


class MyTestCase(unittest.TestCase):
    def setUp(self):
        self.displayedCount = 0
        self.displayed = []
        self.renderer = Renderer(self.display)

    def test_show_numbers_should_display_each_number(self):
        self.renderer.show_numbers(2, self.render)
        self.assertEqual(2, self.displayedCount)

    def test_show_numbers_should_render_number(self):
        self.renderer.show_numbers(1, self.render)
        self.assertEqual("s1", self.displayed[0])

    @staticmethod
    def test_fizz_buzz_test():
        renderer = Renderer(print)
        renderer.show_numbers(100, fizz_buzz)

    def display(self, text):
        self.displayedCount += 1
        self.displayed.append(text)

    @staticmethod
    def render(number):
        return f's{number}'


if __name__ == '__main__':
    unittest.main()
