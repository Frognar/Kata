class NameInverter:
    @staticmethod
    def invert(name):
        if name is None:
            raise AttributeError
        return name.strip()
