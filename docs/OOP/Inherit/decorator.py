# @을 사용해 쉽게 데코레이터 사용

def trace(func):
    def wrapper():
        print(func.__name__, " 함수 시작")
        func()
        print(func.__name__, "함수 끝")
    return wrapper

@trace
def hello():
    print("hello")

@trace
def world():
    print("world")


if __name__ == "__main__":
    hello()
    world()