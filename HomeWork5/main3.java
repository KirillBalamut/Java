package main.java.HomeWork5;

import java.util.Arrays;
// Сортировка массива с использованием кучи

// Инструкция по использованию платформы

// Необходимо разработать программу для сортировки массива целых чисел с использованием сортировки кучей (Heap Sort). Программа должна работать следующим образом:

// Принимать на вход массив целых чисел для сортировки. Если массив не предоставлен, программа использует массив по умолчанию.

// Сначала выводить исходный массив на экран.

// Затем применять сортировку кучей (Heap Sort) для сортировки элементов массива в порядке возрастания.

// Выводить отсортированный массив на экран.

// Ваше решение должно содержать два основных метода: buildTree, который строит сортирующее дерево на основе массива, и heapSort, который выполняет собственно сортировку кучей. Основная часть кода предоставлена вам.

// Программа должна быть способной сортировать массив, даже если он состоит из отрицательных чисел и имеет дубликаты.

// На входе:

// '5 8 12 3 6 9'
// На выходе:

// Initial array:
// [5, 8, 12, 3, 6, 9]
// Sorted array:
// [3, 5, 6, 8, 9, 12]

public class main3 {
    public static void buildTree(int[] tree, int sortLength) {
        for (int i = sortLength / 2 - 1; i >= 0; i--) {
            heapify(tree, sortLength, i);
        }
    }

    public static void heapify(int[] tree, int sortLength, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < sortLength && tree[left] > tree[largest]) {
            largest = left;
        }

        if (right < sortLength && tree[right] > tree[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = tree[i];
            tree[i] = tree[largest];
            tree[largest] = temp;
            heapify(tree, sortLength, largest);
        }
    }

    public static void heapSort(int[] sortArray, int sortLength) {
        buildTree(sortArray, sortLength);

        for (int i = sortLength - 1; i >= 0; i--) {
            int temp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = temp;
            heapify(sortArray, i, 0);
        }
    }
}

public class Printer {
    public static void main(String[] args) {
        int[] initArray;
        if (args.length == 0) {
            initArray = new int[] { 17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1 };
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}

// import java.util.Arrays;

// class HeapSort {
// public static void buildTree(int[] tree, int sortLength) {
// // Для всех вершин дерева начиная с середины сортируемой части массива
// // (движемся влево до нулевого индекса)
// for (int i = sortLength / 2 - 1; i >= 0; i--) {
// int maxIndex;
// // Если у вершины два листа, выбираем больший
// if (i * 2 + 2 <= sortLength - 1) {
// if (tree[i * 2 + 2] > tree[i * 2 + 1]) maxIndex = i * 2 + 2;
// else maxIndex = i * 2 + 1;
// // Иначе один лист
// } else maxIndex = i * 2 + 1;
// // Сравниваем лист с максимальным значением с вершиной, при большем значении
// // дочернего элемента меняем его местами с вершиной
// if (tree[i] < tree[maxIndex]) {
// int temp = tree[i];
// tree[i] = tree[maxIndex];
// tree[maxIndex] = temp;
// }
// }
// }

// public static void heapSort(int[] sortArray, int sortLength) {
// // Выход из рекурсии: длина сортируемой части равна 0
// if (sortLength == 0) return;
// // Выстраивание элементов части массива в виде сортирующего дерева
// buildTree(sortArray, sortLength);
// // Замена местами первого и последнего элемента в сортируемой части
// int temp = sortArray[0];
// sortArray[0] = sortArray[sortLength - 1];
// sortArray[sortLength - 1] = temp;
// // Рекурсивно построение дерева и замена элементов для n - 1 элементов
// массива
// heapSort(sortArray, sortLength - 1);
// }
// }

// public class Printer {
// public static void main(String[] args) {
// int[] initArray;

// if (args.length == 0) {
// initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
// } else {
// initArray = Arrays.stream(args[0].split("
// ")).mapToInt(Integer::parseInt).toArray();
// }

// System.out.println("Initial array:");
// System.out.println(Arrays.toString(initArray));
// HeapSort.heapSort(initArray, initArray.length);
// System.out.println("Sorted array:");
// System.out.println(Arrays.toString(initArray));
// }
// }
