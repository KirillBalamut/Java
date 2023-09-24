package HomeWork1;
//        Вычислить n-ое треугольного число(сумма чисел от 1 до n).
//        Внутри класса Answer напишите метод countNTriangle,
//        который принимает число n и возвращает его n-ое треугольное число.
//

public class Task1 {
    public static void main(String[] args) {
        class Answer {
            public int countNTriangle(int n){
                int sum = 0;
                for(int i = 1; i <= n; i++){
                    sum += i;
                }
                return sum;
            }
        }

        class Printer{
            public static void main(String[] args) {
                int n = 4;

                if (args.length == 0) {
                    n = 4;
                }
                else{
                    n = Integer.parseInt(args[0]);
                }

                Answer ans = new Answer();
                int itresume_res = ans.countNTriangle(n);
                System.out.println(itresume_res);
            }
        }
    }
}
