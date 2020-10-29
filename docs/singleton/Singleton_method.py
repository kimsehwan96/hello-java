class SingletonInstane:
  __instance = None

  @classmethod
  def __getInstance(cls):
    return cls.__instance

  @classmethod
  def instance(cls, *args, **kargs):
    cls.__instance = cls(*args, **kargs)
    cls.instance = cls.__getInstance
    return cls.__instance

class BaseClass:
    def __init__(self):
        self.name = 'kim'
    def get_name(self):
        return self.name

class MyClass(BaseClass, SingletonInstane):
  pass

c1 = MyClass.instance()
c2 = MyClass.instance()
print(c1.get_name())

if id(c1) == id(c2):
    print("c1 & c2 are same instance")
else:
    print("c1 & c2 are not same instance")