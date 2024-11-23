
import java.util.HashSet;

import static java.lang.Math.abs;


public class Main {
    public static int missingNumber(int[] table) {
        int n = table.length;
        int suma = n * (n + 1) / 2;
        int sumaTablicy = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int num : table) {
            if (num < 0) {
                throw new IllegalArgumentException("Niektóre elementy są ujemne");
            }
            if (!set.add(num)) {
                throw new IllegalArgumentException("Niektóre elementy się powtarzają");
            }
            sumaTablicy += num;
        }

        int max = table[0];
        for(int ktr = 0; ktr < table.length; ktr++) {
            if (table[ktr] > max) {
                max = table[ktr];
            }
        }
        if(abs(table.length-max)<1){
            return suma - sumaTablicy;
        }else {
            throw new IllegalArgumentException("Brakuje więcej niż jednej liczby");
        }

    }
    
    public static boolean isPalindrome(String str){
        String nstr="";
        char ch;
        for (int i=0; i<str.length(); i++)
        {
            ch= str.charAt(i);
            nstr= ch+nstr;
        }
        if(str.equals(nstr)){
            return true;
        }else return false;
    }

    public static void printPascal(int n) {
        for (int k=1;k<=n;k++) {
            for (int j=0; j<=n-k;j++) {
                System.out.print(" ");
            }
            int linia=1;
            for (int i=1;i<=k;i++) {
                System.out.print(linia+" ");
                linia=linia*(k - i)/i;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("TEST DLA ZADANIA 1");
        int[] tab1 = {2, 4, 5, 3, 0, 6};
        System.out.println(missingNumber(tab1));
        int[] tab2 = {1,2,3,6};
        //System.out.println(missingNumber(tab2));
        int[] tab3 = {-1,2,3,4}; // Ujemne
        //System.out.println(missingNumber(tab3));
        int[] tab4 = {1,1,1,3};
        //System.out.println(missingNumber(tab4));

        System.out.println("TEST DLA ZADANIA 2");
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("Oskar"));
        System.out.println(isPalindrome("atokanapapanakota"));
        System.out.println(isPalindrome("abbal"));
        System.out.println(isPalindrome("mateusz"));

        System.out.println("TEST DLA ZADANIA 3");
        printPascal(6);



    }

}