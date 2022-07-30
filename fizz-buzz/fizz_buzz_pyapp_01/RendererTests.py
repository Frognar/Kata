import unittest

from Renderer import Renderer


class MyTestCase(unittest.TestCase):
    def setUp(self):
        self.displayedCount = 0
        self.renderer = Renderer(self.display)

    def test_render_should_display_each_number(self):
        self.renderer.render(2)
        self.assertEqual(2, self.displayedCount)

    def display(self, text):
        self.displayedCount += 1


if __name__ == '__main__':
    unittest.main()
