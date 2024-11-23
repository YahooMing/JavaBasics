import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.*;
import java.util.function.Predicate;


public class Main {
    public static <T> List<T> getTail(List<T> list) {
        if (list.isEmpty() || list.size() == 1) {
            return new ArrayList<>();
        } else {
            return list.subList(1, list.size());
        }
    }

    public static <T> T getHead(List<T> list) {
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public static <T> boolean isSorted(List<T> aa, BiPredicate<T, T> ordered){
        int i = 0;
        int j = 1;
        while(j < aa.size()){
            if(ordered.test(aa.get(i), aa.get(j))){
                i++;
                j++;
                continue;
            }
            return false;
        }
        return true;
    }
    public static List<Number> square(List<Number> numbers){
        ArrayList<Number> output = new ArrayList<>();
        for(int i=0; i < numbers.size(); i++){
            if((i-1)%2==0){
                Number numer = numbers.get(i);
                if (numer.doubleValue() > 0) {
                    output.add(Math.pow(numer.doubleValue(), 2));
                }
            }
        }
        return output;
    }

    public static <T> List<T> tailToHead(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("Empty list");
        }
        T lastElement = list.remove(list.size() - 1);
        list.add(0, lastElement);
        return list;
    }

    public static <T> List<T> setHead(List<T> list, T newHead) {
        list.set(0, newHead);
        return list;
    }

    public static <T> List<T> dropWhile(List<T> list, Predicate<T> predicate) {
        int i = 0;
        while (i < list.size() && predicate.test(list.get(i))) {
            i++;
        }
        return list.subList(i, list.size());
    }





    public static void main(String[] args) {


        System.out.println("ZADANIE 1");
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println("Oprócz pierwszego elementu:" + getTail(test));
        System.out.println("Pierwszy element:" + getHead(test));

        System.out.println("-------------------------------------------------");
        System.out.println("ZADANIE 2");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        BiPredicate<Integer, Integer> isAscending = (a, b) -> a <= b;
        System.out.println(isSorted(numbers, isAscending));
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        BiPredicate<String, String> isLexicographic = (a, b) -> a.compareTo(b) <= 0;
        System.out.println(isSorted(words, isLexicographic));

        System.out.println("-------------------------------------------------");
        System.out.println("ZADANIE 3");
        System.out.println(square(Arrays.asList(1, 2, 3.5, 5, -6, 1, 1)));

        System.out.println("-------------------------------------------------");
        System.out.println("ZADANIE 4");
        System.out.println(tailToHead(test));

        System.out.println("-------------------------------------------------");
        System.out.println("ZADANIE 5");
        System.out.println(setHead(test, 5));

        System.out.println("-------------------------------------------------");
        System.out.println("ZADANIE 6");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 3, 2, 1, 9);
        Predicate<Integer> lessThanThree = (i) -> i < 3;
        System.out.println(dropWhile(list, lessThanThree));

    }
}