import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PrimesGenerator implements Iterable<Integer> {

    private final int N;

    public PrimesGenerator(int N) {
        this.N = N;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int count = 0;
            private int number = 2;

            @Override
            public boolean hasNext() {
                return count < N;
            }

            @Override
            public Integer next() {
                while (true) {
                    if (isPrime(number)) {
                        count++;
                        return number++;
                    }
                    number++;
                }
            }

            private boolean isPrime(int num) {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        return false;
                    }
                }
                return true;
            }
        };
    }

    public static void main(String[] args) {
        PrimesGenerator generator = new PrimesGenerator(10);

        // Вывод простых чисел в прямом порядке
        System.out.println("Простые числа (прямой порядок):");
        for (Integer prime : generator) {
            System.out.print(prime + " ");
        }

        // Вывод простых чисел в обратном порядке
        List<Integer> primesList = new LinkedList<>();
        for (Integer prime : generator) {
            primesList.add(prime);
        }
        System.out.println("\nПростые числа (обратный порядок):");
        for (int i = primesList.size() - 1; i >= 0; i--) {
            System.out.print(primesList.get(i) + " ");
        }
    }
}