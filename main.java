abstract class Vehicle {
    private String brand;
    private int kmUsed;
    private int year;
    private double price;

    public Vehicle(String brand, int kmUsed, int year, double price) {
        this.brand = brand;
        this.kmUsed = kmUsed;
        this.year = year;
        this.price = price;
    }

    public abstract void startEngine();

    public void stopEngine() {
        System.out.println(brand + " engine stopped.");
    }

    public String getBrand() {
        return brand;
    }

    public int getKmUsed() {
        return kmUsed;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand + ", KM Used: " + kmUsed + " km, Year: " + year + ", Price: INR " + price);
    }
}

class Car extends Vehicle {
    public Car(String brand, int kmUsed, int year, double price) {
        super(brand, kmUsed, year, price);
    }

    @Override
    public void startEngine() {
        System.out.println(getBrand() + " car engine started.");
    }

    public void openTrunk() {
        System.out.println(getBrand() + " trunk opened.");
    }
}

class Bike extends Vehicle {
    public Bike(String brand, int kmUsed, int year, double price) {
        super(brand, kmUsed, year, price);
    }

    @Override
    public void startEngine() {
        System.out.println(getBrand() + " bike engine started.");
    }

    public void kickStart() {
        System.out.println(getBrand() + " bike kick-started.");
    }
}

class Showroom {
    private Vehicle[] vehicles;
    private int count;

    public Showroom(int capacity) {
        vehicles = new Vehicle[capacity];
        count = 0;
    }

    public void addVehicle(Vehicle vehicle) {
        if (count < vehicles.length) {
            vehicles[count] = vehicle;
            System.out.println(vehicle.getBrand() + " added to the showroom.");
            count++;
        } else {
            System.out.println("Showroom is full! Cannot add more vehicles.");
        }
    }

    public void displayAllVehicles() {
        System.out.println("\n--- Used Vehicle Showroom ---");
        if (count == 0) {
            System.out.println("No vehicles available.");
        } else {
            for (int i = 0; i < count; i++) {
                vehicles[i].displayDetails();
            }
        }
    }
    
    public void startVehicle(int idx){
        vehicles[idx].startEngine();
    }
    
    public void stopVehicle(int idx){
        vehicles[idx].stopEngine();
    }
}

public class Main {
    public static void main(String[] args) {
        Showroom showroom = new Showroom(10);

        Car car1 = new Car("Toyota Camry", 45000, 2015, 1500000);
        Car car2 = new Car("Honda Civic", 30000, 2018, 1800000);
        Bike bike1 = new Bike("Harley-Davidson", 25000, 2012, 1000000);
        Bike bike2 = new Bike("Yamaha R1", 15000, 2019, 1400000);

        showroom.addVehicle(car1);
        showroom.addVehicle(car2);
        showroom.addVehicle(bike1);
        showroom.addVehicle(bike2);

        showroom.startVehicle(2);
        showroom.stopVehicle(2);
        
        showroom.displayAllVehicles();
    }
}