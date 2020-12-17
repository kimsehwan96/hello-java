def trace(func):
    def wrapper(self, r):
        r = func(self, r)
        print("this is com area_circle")
        return r
    return wrapper

class cal:
    def __init__(self):
        self.PI = 3.141592
    def area_circle(self, r):
        return self.PI * r * r

class com1(cal):
    @trace
    def area_circle(self, r):
        return self.PI * r * r

if __name__ =="__main__":
    c = com1()
    print(c.area_circle(5))
