import java.util.*;
import java.util.concurrent.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;


public class Main {
    static class Divisor implements Callable<List<Integer>> {
        Integer num;
        Integer divisor_count = 0;
        public Divisor(Integer num) {
            this.num = num;
        }
        @Override
        public List<Integer> call() {
            for(Integer i = 1; i <= num; i++){
                if(num % i == 0)
                    divisor_count++;
            }
            return Arrays.asList(num, divisor_count);
        }
    }
    public static BigInteger factorial(Integer n){
        BigInteger wyjscie = new BigInteger("0");
        ExecutorService wykonywacz = Executors.newSingleThreadExecutor();
        Callable<BigInteger> wywolanie;
        wywolanie = new Callable<BigInteger>() {
            @Override
            public BigInteger call() throws Exception {
                BigInteger wynik = BigInteger.ONE;
                for (int i = 1; i <= n; i++) {
                    wynik = wynik.multiply(BigInteger.valueOf(i));
                }
                return wynik;
            }
        };

        Future<BigInteger> nastepne_zadanie = wykonywacz.submit(wywolanie);
        try {
            while (!nastepne_zadanie.isDone())
                continue;
            wyjscie = nastepne_zadanie.get();
        } catch (ExecutionException ee) {
            System.err.println("wyjatek");
            ee.printStackTrace();
        } catch (InterruptedException ie) {
            System.err.println("przerwano podczas oczekiwania");
        }
        wykonywacz.shutdown();
        return wyjscie;
    }
    public static BigDecimal zad2(Integer n){
        BigDecimal wynik = BigDecimal.ZERO;
        BigDecimal pierwszy = BigDecimal.ONE;
        for(Integer i = 0; i <= n; i++){
            BigDecimal silnia = new BigDecimal(factorial(i));
            BigDecimal bufor = pierwszy.divide(silnia, MathContext.DECIMAL64);
            wynik = wynik.add(bufor);
        }
        return wynik;
    }
    public static void main(String[] args) {
        System.out.println("ZADANIE 1");
        System.out.println(factorial(10));

        System.out.println("-------------------------------------------------");
        System.out.println("ZADANIE 2");
        System.out.println(zad2(17));

        System.out.println("-------------------------------------------------");
        System.out.println("ZADANIE 3");
        Integer numer = 0;
        Integer dzielnik = 0;
        ExecutorService wyk = Executors.newFixedThreadPool(10);
        List<Future<List<Integer>>> zadania = new ArrayList<>();

        for(Integer num = 1; num < 100000; num++){
            Callable<List<Integer>> divisorTask = new Divisor(num);
            Future<List<Integer>> futureDivisor = wyk.submit(divisorTask);
            zadania.add(futureDivisor);
        }
        for(Future<List<Integer>> task : zadania){
            try {
                if(dzielnik < task.get().get(1)) {
                    numer = task.get().get(0);
                    dzielnik = task.get().get(1);
                }
            } catch (CancellationException | ExecutionException | InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        System.out.printf("liczba = %s", numer);
        System.out.println("");
        System.out.printf("liczba dzielnikow = %s", dzielnik);
        wyk.shutdown();
    }
}