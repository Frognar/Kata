import unittest

from Renderer import Renderer


class RendererTestCase(unittest.TestCase):
    def setUp(self):
        self.displayedCount = 0
        self.displayed = []
        self.renderer = Renderer(self.display)

    def display(self, text):
        self.displayedCount += 1
        self.displayed.append(text)

    @staticmethod
    def render(number):
        return f'py{number}'

    def test_show_numbers_should_display_each_number(self):
        self.renderer.show_numbers(2, self.render)
        self.assertEqual(2, self.displayedCount)

    def test_show_numbers_should_render_number(self):
        self.renderer.show_numbers(1, self.render)
        self.assertEqual('py1', self.displayed[0])


if __name__ == '__main__':
    unittest.main()
