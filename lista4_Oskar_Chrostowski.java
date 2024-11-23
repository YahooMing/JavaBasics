import java.util.function.BiFunction;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static int suma(List<Integer> a) {
        return a.stream().filter(x -> x > 0).reduce(0, Integer::sum);
    }

    public static Map<String, Integer> countElements(List<List<String>> lists) {
        return lists.stream().flatMap(List::stream).collect(Collectors.groupingBy(e -> e, Collectors.summingInt(e -> 1) ));
    }
    public static List<Integer> evenPositiveSquare(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        result = numbers.stream()
                .filter(num -> num > 0 && numbers.indexOf(num) % 2 != 0)
                .map(num -> num * num)
                .toList();
        return result;
    }

    public static List<List<Integer>> perm(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.isEmpty()) {
            result.add(new ArrayList<>());
            return result;
        }
        for (int i = 0; i < nums.size(); i++) {
            int current = nums.get(i);
            List<Integer> remaining = new ArrayList<>(nums.subList(0, i));
            remaining.addAll(nums.subList(i + 1, nums.size()));
            List<List<Integer>> perms = perm(remaining);
            for (List<Integer> perm : perms) {
                perm.add(0, current);
                result.add(perm);
            }
        }
        return result;
    }
    public static List<List<Object>> srt(List<String> strings) {
        Map<Character, List<String>> groupedByFirstLetter = strings.stream()
                .filter(str -> str.length() % 2 == 0)
                .collect(Collectors.groupingBy(str -> str.charAt(0), Collectors.toList()
                        )
                );
        List<List<Object>> result = new ArrayList<>();
        groupedByFirstLetter.forEach((key, value) -> {
            List<Object> sublist = new ArrayList<>();
            sublist.add(key);
            sublist.add(value);
            result.add(sublist);
        });
        result.sort(Comparator.comparing(obj -> obj.get(0).toString()));
        return result;
    }

    public static int check(int N, List<Integer> numbers) {
        Set<Integer> preamble = new HashSet<>(numbers.subList(0, N));
        for (int i = N; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            boolean isValid = false;
            for (int preambleNum : preamble) {
                int complement = currentNumber - preambleNum;
                if (complement != preambleNum && preamble.contains(complement)) {
                    isValid = true;
                    break;
                }
            }
            if (!isValid) {
                return currentNumber;
            }
            preamble.remove(numbers.get(i - N));
            preamble.add(currentNumber);
        }
        return -1;
    }


    public static void main(String[] args) {
        BiFunction<String, Integer, String> lambda = (s, i) -> {
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < i; j++) {
            result.append(s);
        }
        return result.toString();
    };

        System.out.println("ZADANIE 1");
        String wynik1 = lambda.apply("a",3);
        System.out.println(wynik1);
        System.out.println("ZADANIE 2");
        System.out.println(suma(List.of( 1, -4, 12, 0, -3, 29, -150)));
        System.out.println("ZADANIE 3");
        System.out.println(countElements(List.of(List.of("a", "b", "c"), List.of("c", "d", "f"), List.of("d", "f", "g"))));
        System.out.println("ZADANIE 4");
        System.out.println(evenPositiveSquare(List.of(1, 2, 3, 5, -6, -1, -1, 2, 3)));
        System.out.println("ZADANIE 5");
        System.out.println(srt(List.of("applle","cherry", "blueberry", "citrus", "apple", "apricot", "banana", "coconut")));
        System.out.println("ZADANIE 6");
        System.out.println(perm(List.of(1,2,3)));
        System.out.println("ZADANIE 7");
        System.out.println(check(2,List.of(1,2,3,4,5,6)));
        System.out.println(check(5, List.of(35, 25, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)));
    }

}