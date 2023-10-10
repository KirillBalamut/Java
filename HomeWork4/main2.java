package main.java.HomeWork4;

import java.util.LinkedList;
// В классе MyQueue реализуйте очередь с помощью LinkedList со следующими методами:

import javax.lang.model.element.Element;

// enqueue() - помещает элемент в конец очереди
// dequeue() - возвращает первый элемент из очереди и удаляет его
// first() - возвращает первый элемент из очереди, не удаляя
// getElements() - возвращает все элементы в очереди
// Пример

// queue.enqueue(1);
// queue.enqueue(10);
// queue.enqueue(15);
// queue.enqueue(5);
// System.out.println(queue.getElements()); 
// // [1, 10, 15, 5]

// queue.dequeue();
// queue.dequeue();
// System.out.println(queue.getElements());
// // [15, 5]

// System.out.println(queue.first());
// // 15

public class main2 {
    class MyQueue<T> {
        private LinkedList<T> elements;

        public MyQueue() {
            elements = new LinkedList<>();
        }

        public void enqueue(T element) {
            elements.addLast(element);
        }

        public T dequeue() {
            return elements.removeFirst();
        }

        public T first() {
            return elements.getFirst();
        }

        public LinkedList<T> getElements() {
            return elements;
        }
    }

public class Printer {
    public static void main(String[] args) {
        MyQueue<Integer> queue;
        queue = new MyQueue<>();
        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            queue.enqueue(1);
            queue.enqueue(10);
            queue.enqueue(15);
            queue.enqueue(5);
        } else {
            queue.enqueue(Integer.parseInt(args[0]));
            queue.enqueue(Integer.parseInt(args[1]));
            queue.enqueue(Integer.parseInt(args[2]));
            queue.enqueue(Integer.parseInt(args[3]));
        }
        System.out.println(queue.getElements());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getElements());
        System.out.println(queue.first());
    }
}

// import java.util.LinkedList;

// class MyQueue<T> {
// private LinkedList<T> elements = new LinkedList<>();

// public MyQueue() {
// }

// public MyQueue(LinkedList<T> elements) {
// this.elements = elements;
// }

// public void enqueue(T element){
// elements.add(element);
// }

// public T dequeue(){
// T first = elements.getFirst();
// elements.removeFirst();
// return first;
// }

// public T first(){
// return elements.getFirst();
// }

// public LinkedList<T> getElements() {
// return elements;
// }

// public void setElements(LinkedList<T> elements) {
// this.elements = elements;
// }
// }

// public class Printer {
// public static void main(String[] args) {
// MyQueue<Integer> queue;
// queue = new MyQueue<>();

// if (args.length == 0) {
// queue.enqueue(1);
// queue.enqueue(10);
// queue.enqueue(15);
// queue.enqueue(5);
// } else {
// queue.enqueue(Integer.parseInt(args[0]));
// queue.enqueue(Integer.parseInt(args[1]));
// queue.enqueue(Integer.parseInt(args[2]));
// queue.enqueue(Integer.parseInt(args[3]));
// }

// System.out.println(queue.getElements());

// queue.dequeue();
// queue.dequeue();
// System.out.println(queue.getElements());

// System.out.println(queue.first());
// }
// }
