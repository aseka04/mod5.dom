package dom;

import java.util.Scanner;

interface IVehicle {
    void Drive();
    void Refuel();

}
class Car implements IVehicle{
    String marka;
    String model;
    String type;

    public Car(String marka, String model, String type) {
        this.marka = marka;
        this.model = model;
        this.type = type;
    }
    public Car(){}

    public void Drive() {
        System.out.println("car start drive");
    }

    public void Refuel() {
        System.out.println("Refuel");
    }

    @Override
    public String toString() {
        return "Car{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}



class Motorcycle implements IVehicle{
    String type;
    int obem;

    public Motorcycle(String type, int obem) {
        this.type = type;
        this.obem = obem;
    }

    public Motorcycle(){}
    public void Drive() {
        System.out.println("Motorcycle start drive");
    }

    public void Refuel() {
        System.out.println("Refuel");

    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "type='" + type + '\'' +
                ", obem=" + obem +
                '}';
    }
}

class Truck implements IVehicle{
    int podem;
    int os;

    @Override
    public String toString() {
        return "Truck{" +
                "podem=" + podem +
                ", os=" + os +
                '}';
    }

    public Truck(int podem, int os) {
        this.podem = podem;
        this.os = os;
    }

    public Truck(){}
    public void Drive() {
        System.out.println("Truck start drive");
    }

    public void Refuel() {
        System.out.println("Refuel");
    }

}
abstract class VehicleFactory{
    String marka;
    String model;

    @Override
    public String toString() {
        return "VehicleFactory{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public VehicleFactory(String marka, String model) {
        this.marka = marka;
        this.model = model;
    }

    public abstract IVehicle createVehicle(String marka, String model);
}
class CarFactory extends VehicleFactory {
    public CarFactory(String marka, String model) {
        super(marka, model);
    }

    public IVehicle createVehicle(String marka, String model) {
        return new Car();
    }
}
class MotorcycleFactory extends VehicleFactory {
    public MotorcycleFactory(String marka, String model) {
        super(marka, model);
    }

    public IVehicle createVehicle(String marka, String model) {
        return new Motorcycle();
    }
}
class TruckFactory extends VehicleFactory {
    public TruckFactory(String marka, String model) {
        super(marka, model);
    }

    public IVehicle createVehicle(String marka, String model) {
        return new Truck();
    }
}

class Bus implements IVehicle {
    private int col;

    public Bus(String marka, String model, int col) {
        this.col = col;
    }
    public Bus(){}

    public void Drive() {
        System.out.println("Truck start drive");
    }

    public void Refuel() {
        System.out.println("Refuel");
    }

    @Override
    public String toString() {
        return "Bus{" +
                "col=" + col +
                '}';
    }
}

class BusFactory extends VehicleFactory {
    public BusFactory(String marka, String model) {
        super(marka, model);
    }

    public IVehicle createVehicle(String marka, String model) {
        return new Bus();
    }

}
class Main{
    public static void main(String[] args) {
        System.out.println("1-car\n2-motorcycle\n3-truck\n4-bus");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        switch (a){
            case 1:
                System.out.println("marka:");
                String marka = sc.next();
                System.out.println("model:");
                String model = sc.next();
                System.out.println("type:");
                String type = sc.next();
                Car car = new Car(marka, model, type);
                System.out.println(car);
                VehicleFactory carFactory = new CarFactory(marka,model);
                System.out.println(carFactory);
                break;
            case 2:
                System.out.println("marka:");
                String marka1 = sc.next();
                System.out.println("model:");
                String model1 = sc.next();
                System.out.println("type:");
                String type1 = sc.next();
                System.out.println("obem: ");
                int obem = sc.nextInt();
                Motorcycle motorcycle = new Motorcycle(type1, obem);
                System.out.println(motorcycle);
                VehicleFactory motorcycleFactor = new MotorcycleFactory(marka1, model1);
                System.out.println(motorcycleFactor);
                break;
            case 3:
                System.out.println("marka:");
                String marka2 = sc.next();
                System.out.println("model:");
                String model2 = sc.next();
                System.out.println("podem");
                int podem = sc.nextInt();
                System.out.println("os");
                int os = sc.nextInt();
                Truck truck = new Truck(podem, os);
                System.out.println(truck);
                VehicleFactory truckFactory = new TruckFactory(marka2, model2);
                System.out.println(truckFactory);
                break;
            case 4:
                System.out.println("marka:");
                String marka3 = sc.next();
                System.out.println("model:");
                String model3 = sc.next();
                System.out.println("col");
                int col = sc.nextInt();
                Bus bus = new Bus(marka3, model3, col);
                System.out.println(bus);
                VehicleFactory busFactory = new BusFactory(marka3, model3);
                System.out.println(busFactory);
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}