def trace(func):
    def wrapper(a, b):
        r = func(a, b)
        print("{} (a = {}, b = {} , r = {})".format(func.__name__, a, b, r))
        return r
    return wrapper

@trace
def add(a, b):
    return a + b


if __name__ == "__main__":
    print(add(10, 5))