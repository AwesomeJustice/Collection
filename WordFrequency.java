import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "Hello hello world world hello world";

        // Преобразуем строку в массив слов и подсчитаем частоту
        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Выводим результат
        frequencyMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}