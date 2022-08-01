class Renderer:
    def __init__(self, display):
        self.display = display

    def show_numbers(self, count, render):
        [self.display(render(n + 1)) for n in range(count)]

    
