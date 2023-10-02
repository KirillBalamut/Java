// Напишите функцию analyzeNumbers, которая принимает на вход целочисленный список arr и:

// Сортирует его по возрастанию и выводит на экран
// Находит минимальное значение в списке и выводит на экран - Minimum is {число}
// Находит максимальное значение в списке и выводит на экран - Maximum is {число}
// Находит среднее арифметическое значений списка и выводит на экран - Average is =  {число}
// Напишите свой код в методе analyzeNumbers класса Answer. Метод analyzeNumbers принимает на вход один параметр:

// Integer[] arr - список целых чисел
import java.util.Arrays;
import java.util.ArrayList;

public class Task3 {
    class Answer {
        public static void analyzeNumbers(Integer[] arr) {
            // Введите свое решение ниже
            // Сортировка массива по возрастанию
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));

            // Нахождение минимального значения
            int min = arr[0];
            System.out.println("Minimum is " + min);

            // Нахождение максимального значения
            int max = arr[arr.length - 1];
            System.out.println("Maximum is " + max);

            // Нахождение среднего арифметического
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            int average = (int) sum / arr.length;
            System.out.println("Average is = " + average);
        }
    }

    // Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
    public class Printer {
        public static void main(String[] args) {
            Integer[] arr = {};

            if (args.length == 0) {
                // При отправке кода на Выполнение, вы можете варьировать эти параметры
                arr = new Integer[] { 4, 2, 7, 5, 1, 3, 8, 6, 9 };
            } else {
                arr = Arrays.stream(args[0].split(", "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
            }

            Answer ans = new Answer();
            ans.analyzeNumbers(arr);
        }
    }
}
// код автотеста
// import java.util.Arrays;
// import java.util.ArrayList;

// class Answer {
// public static void analyzeNumbers(Integer[] arr) {
// ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(arr));
// ints.sort(Integer::compareTo); // сортировка списка по возрастанию
// System.out.println(ints); // вывод списка на экран
// System.out.println("Minimum is " + ints.get(0)); // нахождение минимального
// значения в списке и вывод на экран
// System.out.println("Maximum is " + ints.get(ints.size()-1)); // нахождение
// максимального значения в списке и вывод на экран

// int sum = 0;
// for(int i : ints){ // вычисление суммы всех элементов списка
// sum += i;
// }
// System.out.println("Average is = " + sum / ints.size()); // вычисление
// среднего арифметического значений списка и вывод на экран
// }
// }

// public class Printer{
// public static void main(String[] args) {
// Integer[] arr = {};

// if (args.length == 0) {
// arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
// }
// else{
// arr = Arrays.stream(args[0].split(", "))
// .map(Integer::parseInt)
// .toArray(Integer[]::new);
// }

// Answer ans = new Answer();
// ans.analyzeNumbers(arr);
// }
// }