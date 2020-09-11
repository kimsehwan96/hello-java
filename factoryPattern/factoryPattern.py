from abc import ABC, abstractmethod

class Shape(ABC):
    @abstractmethod
    def draw(self):
        pass

class Circle(Shape):
    def draw(self):
        print("circle method")

class Rectangle(Shape):
    def draw(self):
        print("Rectangle method")

class Square(Shape):
    def draw(self):
        print("Square method")

class ShapeFactory:
    def getShape(self, shape):
        return shape.draw()

shape_factory = ShapeFactory()

shape_factory.getShape(Circle())
shape_factory.getShape(Square())
shape_factory.getShape(Rectangle())