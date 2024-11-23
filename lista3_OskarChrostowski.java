
import java.util.HashMap;
import java.util.HashSet;
import java.util.*;
import java.util.Map;

public class Main {
    static HashMap<String, Integer> countOccurrences(String strink)
    {
        HashMap<String, Integer> ilosc = new HashMap<String, Integer>();
        String str = strink.replaceAll("\\p{Punct}", "");
        str = str.toLowerCase();
        String slowo[] = str.split(" ");
        for (int i = 0; i < slowo.length; i++)
        {
            if(!ilosc.containsKey(slowo[i])){
                ilosc.put(slowo[i],1);
                continue;
            }
            ilosc.put(slowo[i],ilosc.get(slowo[i])+1);
        }
       return ilosc;
    }

    public static List<Integer> findDuplicates(List<Integer> list) {
        Set<Integer> jednorazowe = new HashSet<>();
        Set<Integer> wielorazowe = new TreeSet<>();
        for (int i : list) {
            if (!jednorazowe.add(i)) {
                wielorazowe.add(i);
            }
        }
        return new ArrayList<>(wielorazowe);
    }

    public static Map<Integer, Boolean> addToBoolean(){
        Map<Integer, Boolean> mapa = new HashMap<>() ;
        for(int i=1;i<=20;i++){
            if(i%2==0){
                mapa.put(i,true);
            }else {
                mapa.put(i,false);
            }
        }
        return mapa;
    }
    public static void main(String[] args) {
        System.out.println("ZADANIE 1");
        HashMap<String, Integer> zadanie1 = countOccurrences("To jest przykładowe zdanie. To nie jest prawdziwe zdanie,!!!!!?");
        for (String i : zadanie1.keySet()) {
            System.out.println("Slowo '" + i + "' wystepuje " + zadanie1.get(i) + " razy");
        }
        System.out.println("ZADANIE 2");
        System.out.println(findDuplicates(List.of(1,2,2,2,2,3,3,3,4,5,6,7,8,9)));
        System.out.println(findDuplicates(List.of(1,2,2,2,2,3,3,3,4,5,6,7,8,9,9,9,9,10,10)));
        System.out.println("ZADANIE 3");
        System.out.println(addToBoolean());




    }

}