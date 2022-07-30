class Renderer:
    def __init__(self, display):
        self.display = display

    def show_numbers(self, count, render):
        [self.display(render(i + 1)) for i in range(count)]
