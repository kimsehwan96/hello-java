from abc import ABCMeta, abstractmethod


# 우선 베이스 클래스가 되는 Vehicle을 추상클래스로 만든다
class Vehicle(metaclass=ABCMeta): 
    @abstractmethod
    def run(self): #run은 추상메서드로 자식 클래스에서 구현을 강제하자.
        raise NotImplemented ("추상클래스의 추상메서드를 사용하려고 했습니다.")
    #굳이 이렇게 하지 않아도 됩니다.

class Taxi(Vehicle):
    def run(self):
        print("택시가 달립니당")

class Bus(Vehicle):
    def run(self):
        print("버스가 달립니당")

class wrongChild(Vehicle):
    pass
class Driver:
    def drive(self, VehicleCls):
        VehicleCls.run()

if __name__ == "__main__":
    driver = Driver()
    bus = Bus()
    taxi = Taxi()
    #baboCar = wrongChild() #run 추상메서드가 구현되지 않아서 생성되지 않습니다.
    Vehicle.run(Vehicle)#추상클래스의 추상 메서드를 바로 쓰려고 함
    #baseCar = Vehicle() 인스턴스 생성 불가능합니다.

    driver.drive(bus)
    driver.drive(taxi)
    #driver.drive(baboCar)
    #driver.drvie(baseCar)
    