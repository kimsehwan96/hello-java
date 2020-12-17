
class Clac:
    @staticmethod
    def add(a, d):
        return a + d
#static 메서드 데코레이터를 사용한 것.

def trace(func):
    def wrapper():
        print(func.__name__, "함수 시작")
        func()
        print(func.__name__, "힘수 끝")
    return wrapper


def hello():
    print("hello")

def world():
    print("world")

if __name__ == "__main__":
    trace_hello = trace(hello)
    trace_hello()
    trace_world = trace(world)
    trace_world()