import unittest

from Renderer import Renderer


class RendererTestCase(unittest.TestCase):
    def setUp(self):
        self.displayedCount = 0
        self.renderer = Renderer(self.display)

    def test_show_numbers_should_display_each_number(self):
        self.renderer.show_numbers(2)
        self.assertEqual(2, self.displayedCount)

    def display(self, text):
        self.displayedCount += 1


if __name__ == '__main__':
    unittest.main()
