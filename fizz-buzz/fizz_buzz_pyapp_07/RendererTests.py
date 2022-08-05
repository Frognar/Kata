import unittest

from Renderer import Renderer


class RendererTestCase(unittest.TestCase):
    def setUp(self):
        self.displayCount = 0
        self.renderer = Renderer(self.display)

    def display(self, text):
        self.displayCount += 1

    def test_show_numbers_display_each_number(self):
        self.renderer.show_numbers(2)
        self.assertEqual(2, self.displayCount)


if __name__ == '__main__':
    unittest.main()
