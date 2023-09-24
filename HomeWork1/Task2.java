package HomeWork1;
//Напишите функцию printPrimeNums, которая выведет на экран все простые числа в промежутке
// от 1 до 1000, каждое на новой строке.
//  Напишите свой код в методе printPrimeNums класса Answer.
//

public class Task2 {
    public static void main(String[] args) {
        class Answer {
            public void printPrimeNums(){
                boolean isPrime;
                for(int i = 1; i < 1000; i++) {
                    isPrime = i == 1;
                    for(int j = 2; j < 1000; j++) {
                        if (i >= j && i % j == 0) {
                            if(j == i) {
                                isPrime = true;
                            }
                            break;
                        }
                    }
                    if(isPrime) System.out.println(i);
                }
            }
        }

        class Printer{
            public static void main(String[] args) {

                Answer ans = new Answer();
                ans.printPrimeNums();

            }
        }
        }
    }

