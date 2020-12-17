class Parent:
    def __init__(self):
        pass

    def method1(self):
        print("method1 in Parent")
    
    def method2(self):
        print("method2 in Parent")

class Child(Parent):
    def method2(self):
        print("method2 in Child")
    
    def call_parent_method(self):
        super(Child, self).method2()


if __name__ == "__main__":
    p = Parent()
    c = Child()

    c.method2()
    c.call_parent_method()