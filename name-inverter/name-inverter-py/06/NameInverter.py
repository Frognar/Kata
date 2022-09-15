class NameInverter:
    @classmethod
    def invert(cls, name: str) -> str:
        if name is None:
            raise AttributeError
        return name.strip()
