import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class CollectionsExample {

    public static void main(String[] args) {
        int N = 10;  // Размер массива
        int[] numbers = new int[N];
        Random rand = new Random();

        // Заполнение массива случайными числами от 0 до 100
        for (int i = 0; i < N; i++) {
            numbers[i] = rand.nextInt(101);  // Генерация числа от 0 до 100
        }

        // Вывод массива на экран
        System.out.println("Массив случайных чисел: " + Arrays.toString(numbers));
    
      
        List<Integer> numberList = new ArrayList<>(List.of(34, 23, 56, 78, 12,34));
        
        // Сортировка списка по возрастанию
        Collections.sort(numberList);
        System.out.println("Отсортированный список по возрастанию: " + numberList);

        // Сортировка списка по возрастанию
        Collections.sort(numberList);

        // Сортировка в обратном порядке
        Collections.reverse(numberList);
        System.out.println("Отсортированный список в обратном порядке: " + numberList);

        // Перемешивание списка
        Collections.shuffle(numberList);
        System.out.println("Перемешанный список: " + numberList);

        // Циклический сдвиг на 1 элемент
        Collections.rotate(numberList, 1);
        System.out.println("Список после циклического сдвига на 1 элемент: " + numberList);
        
        // Подсчитаем количество каждого элемента
        Map<Integer, Long> frequencyMap = numberList.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // Оставим только дублирующиеся элементы
        List<Integer> duplicates = numberList.stream()
                .filter(e -> frequencyMap.get(e) > 1)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Список с дублирующимися элементами: " + duplicates);

        // Получение массива из списка
        Integer[] numberArray = numberList.toArray(new Integer[0]);
        System.out.println("Массив из списка: " + Arrays.toString(numberArray));

        // Подсчёт вхождений каждого числа
        Map<Integer, Integer> frequencMap = new HashMap<>();
        for (Integer num : numberList) {
            frequencMap.put(num, frequencMap.getOrDefault(num, 0) + 1);
        }

        // Выводим на экран количество вхождений
        frequencMap.forEach((key, value) -> System.out.println(key + ": " + value));
        
    }
}