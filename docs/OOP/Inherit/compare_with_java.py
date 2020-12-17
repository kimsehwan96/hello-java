
class cal:
    def __init__(self):
        self.PI = 3.141592
    def area_circle(self, r):
        return self.PI * r * r

class com1(cal):
    def area_circle(self, r):
        ac = super(com1, self).area_circle(r)
        print("Calculator's area circle override in com")
        return ac

if __name__ == "__main__":
    c = com1()
    print(c.area_circle(5))