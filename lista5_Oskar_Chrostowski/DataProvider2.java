import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public final class DataProvider2 {
    private DataProvider2() {
    }

    private static ArrayList<Cost> getGeneralCosts(int size) {
        ArrayList<Cost> items = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            items.add(new Cost(
                    CostType
                            .values()[new Random()
                            .nextInt(CostType.values().length)],
                    LocalDate.of(
                            2022,
                            new Random().nextInt(12) + 1,
                            new Random().nextInt(28) + 1),
                    new Random().nextInt(5000)));
        }
        return items;
    }

    static ArrayList<Car> getCarCosts(){
        ArrayList<Car> items = new ArrayList<>();
        items.add(new Car(
                "Domowy",
                "Skoda",
                "Fabia",
                2002,
                getGeneralCosts(100)));
        items.add(new Car(
                "Służbowy",
                "BMW",
                "Coupe",
                2015,
                getGeneralCosts(50)));
        items.add(new Car(
                "Kolekcjonerski",
                "Fiat",
                "125p",
                1985,
                getGeneralCosts(10)));
        return items;
    }

}