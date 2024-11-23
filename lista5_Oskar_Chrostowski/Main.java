import java.util.*;

public class Main {
    public static Map<String, ArrayList<Cost>> groupedCostMap(ArrayList<Cost> array){
    Map<String, ArrayList<Cost>> output = new LinkedHashMap<>();
    array.sort(new Comparator<Cost>() {
        @Override
        public int compare(Cost first, Cost second) {
            return first.getDate().getDayOfYear() - second.getDate().getDayOfYear();
        }
    });

    for(int i=0; i < array.size(); i++) {
        ArrayList<Cost> magazine = new ArrayList<Cost>();
        if(output.containsKey(array.get(i).getDate().getMonth().toString())){
            for(Cost elem : output.get(array.get(i).getDate().getMonth().toString()))
                magazine.add(elem);
            magazine.add(array.get(i));
            output.replace(array.get(i).getDate().getMonth().toString(), magazine);
            continue;
        }
        magazine.add(array.get(i));
        output.put(array.get(i).getDate().getMonth().toString(),magazine);
    }
    return output;
}
    public static void printCost(ArrayList<Cost> list){
        list.sort(new Comparator<Cost>() {
            @Override
            public int compare(Cost cost1, Cost cost2) {
                return cost1.getDate().compareTo(cost2.getDate());
            }
        });
        String currentMonth = null;
        for(Cost costs : list){
            String month = costs.getDate().getMonth().toString();
            String day = Integer.toString(costs.getDate().getDayOfMonth());
            String type = costs.getType().toString();
            String value = Integer.toString(costs.getAmount());
            if (!month.equals(currentMonth)) {
                currentMonth = month;
                System.out.println(month + ":");
            }
            System.out.printf("\t%s %s %s zł\n", day, type, value);
        }
    }
    public static void printFullCost(HashMap<CostType, Integer> full_costs){
        full_costs.forEach((key, value) -> {
            System.out.printf("%s %s\n", key.toString(),value.toString());
        });
    }
    public static HashMap<CostType, Integer> getFullCosts(ArrayList<Car> car_list){
        HashMap<CostType, Integer> output = new HashMap<CostType, Integer>();
        for(Car car : car_list){
            for(Cost cost : car.getCosts()){
                if(!output.containsKey(cost.getType())){
                    output.put(cost.getType(), cost.getAmount());
                    continue;
                }
                int temp = output.get(cost.getType());
                output.put(cost.getType(), temp + cost.getAmount());
            }
        }
        return output;
    }
    public static ArrayList<Pair> getCarCosts(String name, ArrayList<Car> arraylist){

        HashMap<CostType, Integer> values = new HashMap<>();
        for(Car car : arraylist){
            if(name == car.getName()){
                for(Cost cost : car.getCosts()){
                    if(!values.containsKey(cost.getType())){
                        values.put(cost.getType(), cost.getAmount());
                        continue;
                    }
                    Integer temp =  values.get(cost.getType()) + cost.getAmount();
                    values.put(cost.getType(),temp);
                }
            }
        }
        ArrayList<Pair> wynik = new ArrayList<>();
        for(Map.Entry<CostType, Integer> entry : values.entrySet()){
            Pair element = new Pair(entry.getKey(), entry.getValue());
            wynik.add(element);
        }
        return wynik;
    }

    public static void printFullCosts(ArrayList<Pair> car_costs){
        for(Pair car : car_costs){
            System.out.println(car);
        }
    }



    public static void main(String[] args){
        ArrayList<Cost> test = DataProvider.getGeneralCosts(6);
        System.out.println("ZADANIE 1");
        System.out.println(groupedCostMap(test));
        System.out.println("----------------------------------------------------------");
        System.out.println("ZADANIE 2");
        printCost(test);
        System.out.println("----------------------------------------------------------");
        System.out.println("ZADANIE 3");
        printFullCosts(getCarCosts("Domowy", DataProvider.getCarCosts()));
        System.out.println("----------------------------------------------------------");
        System.out.println("ZADANIE 4");
        printFullCost(getFullCosts(DataProvider.getCarCosts()));
    }
}
