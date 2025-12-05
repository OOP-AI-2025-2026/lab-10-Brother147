package ua.opnu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EasyTasks {

    public static void main(String[] args) {
        // Запустіть тести з папки src/test, щоб перевірити правильність реалізації методів.
    }

    // Завдання 1: кожне число помножити на 2
    public List<Integer> doubling(List<Integer> nums) {
        return nums.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
    }

    // Завдання 2: кожне число помножити само на себе
    public List<Integer> square(List<Integer> nums) {
        return nums.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // Завдання 3: додати 'y' на початку та в кінці кожного рядка
    public List<String> moreY(List<String> strings) {
        return strings.stream()
                .map(s -> "y" + s + "y")
                .collect(Collectors.toList());
    }

    // Завдання 4: прибрати всі від’ємні числа
    public List<Integer> noNeg(List<Integer> nums) {
        return nums.stream()
                .filter(n -> n >= 0)
                .collect(Collectors.toList());
    }

    // Завдання 5: прибрати всі числа, що закінчуються на 9
    public List<Integer> no9(List<Integer> nums) {
        return nums.stream()
                .filter(n -> Math.abs(n) % 10 != 9)
                .collect(Collectors.toList());
    }

    // Завдання 6: прибрати всі рядки, що містять букву 'z'
    public List<String> noZ(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.contains("z"))
                .collect(Collectors.toList());
    }

    // Завдання 7: прибрати дублікати та відсортувати за спаданням довжини рядка
    public List<String> refinedStrings(List<String> strings) {
        return strings.stream()
                .distinct()
                .sorted(
                        Comparator.comparingInt(String::length)
                                .reversed()
                                .thenComparing(Comparator.naturalOrder())
                )
                .collect(Collectors.toList());
    }

    // Завдання 8: "розплющити" список рядків формату "Ім'я Прізвище" у список окремих слів
    public List<String> flatten(List<String> strings) {
        return strings.stream()
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .filter(token -> !token.isEmpty())
                .collect(Collectors.toList());
    }

}
