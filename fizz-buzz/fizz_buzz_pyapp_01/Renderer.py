class Renderer:
    def __init__(self, display):
        self.display = display

    def show_numbers(self, count):
        [self.display("txt") for _ in range(count)]
