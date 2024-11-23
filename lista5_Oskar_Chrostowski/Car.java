import java.util.ArrayList;

public class Car {
    private final String name;
    private final String brand;
    private final String model;
    private final int yearOfProduction;
    private ArrayList<Cost> costs;

    public Car(
            String name,
            String brand,
            String model,
            int yearOfProduction,
            ArrayList<Cost> costs
    ) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.costs = costs;
    }

    public void setCosts(ArrayList<Cost> costs) {
        this.costs = costs;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public ArrayList<Cost> getCosts() {
        return costs;
    }
}