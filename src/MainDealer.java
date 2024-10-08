
//Create Dealer Class
//In the dealer store money, Cars and information about dealer.
//IT should have show all cars, sell car and add car functions.
//To manage everything we need to have a menu so we need to have dealerMenu() function so that we will just run it and we will control other functions by scanners.

import java.util.ArrayList;
import java.util.Scanner;

public class MainDealer {
    public static void main(String[] args) {
       // Car car = new Car("Ranger Rover","2020", 20000);
        Dealer dealer = new Dealer("Super Cars", 10000.00);
        dealer.dealerMenu();
        //System.out.println(car);

    }

}
class Car {
    private String name;
    private String model;
    private double price;


    public Car(String name,String model, double price) {
        this.name = name;
        this.model = model;
        this.price = price;

    }
    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}

class Dealer{
    private String dealerName;
    private double money;
    private ArrayList<Car> cars;

    public Dealer(String dealerName, double money) {
        this.dealerName = dealerName;
        this.money = money;
        this.cars = new ArrayList<>();
    }
    public void showAllCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
        } else {
            System.out.println("Available cars:");
            for (Car car : cars) {
                System.out.println(car);
            }
        }
    }

    // Add a car to the dealer's inventory
    public void addCar(String name,String model, double price) {
        cars.add(new Car(name, model, price));
        System.out.println(name + " added to the inventory.");
    }
    public void sellCar(String model) {
        Car carToSell = null;
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model)) {
                carToSell = car;
                break;
            }
        }

        if (carToSell != null) {
            cars.remove(carToSell);
            money += carToSell.getPrice();
            System.out.println("Sold " + model + " for $" + carToSell.getPrice());
        } else {
            System.out.println("Car not found.");
        }
    }
    public void showDealerInfo() {
        System.out.println("Dealer Name: " + dealerName);
        System.out.println("Current Money: $" + money);
        System.out.println("Number of Cars: " + cars.size());
    }
    public void dealerMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Dealer Menu ---");
            System.out.println("1. Show All Cars");
            System.out.println("2. Add Car");
            System.out.println("3. Sell Car");
            System.out.println("4. Show Dealer Info");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    showAllCars();
                    break;
                case 2:
                    System.out.print("Enter Car Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Car Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter Car Price: ");
                    double price = scanner.nextDouble();
                    addCar(name,model, price);
                    break;
                case 3:
                    System.out.print("Enter Car Model to Sell: ");
                    String sellModel = scanner.nextLine();
                    sellCar(sellModel);
                    break;
                case 4:
                    showDealerInfo();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return; // Exit the loop and end the menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}