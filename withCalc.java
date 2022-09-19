import java.io.IOException;
import java.lang.ArithmeticException; //Выбрал стандартное исключения для выброса ошибок указанных в тз
import java.util.Scanner;
public class withCalc {
    public static void main(String[] args) throws IOException, ArithmeticException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическую операцию через пробел");
        String[] mas = new String[3];
        mas = scanner.nextLine().split(" ");
        String a = mas[0];
        String b = mas[1];
        String c = mas[2];
        int v = mas.length;
        boolean j;
        j = b.equals("+");
        int l1 = 0;
        if (j == false) {
            l1 = 1;
        }
        j = b.equals("-");
        int l2 = 0;
        if (j == false) {
            l2 = 1;

        }
        j = b.equals("*");
        int l3 = 0;
        if (j == false) {
            l3 = 1;
        }
        j = b.equals("/");
        int l4 = 0;
        if (j == false) {
            l4 = 1;
        }
        if ((l1 == 1) & (l2 == 1) & (l3 == 1) & (l4 == 1)) {
            throw new ArithmeticException();
        }
            if (v > 4) {
                throw new ArithmeticException();
            }
            Roman currentA = null;
            Roman currentC = null;
            try {
                currentA = Roman.valueOf(a);
            } catch (Exception e) {
            }
            try {
                currentC = Roman.valueOf(c);
            } catch (Exception e) {
            }
            if ((currentA == null) & (currentC == null)) {
                int d = Integer.parseInt(a);
                int g = Integer.parseInt(c);
                if ((d > 10) & (g > 10)) {
                    throw new ArithmeticException();
                }
                int result = calc(d, g, b);
                System.out.println("Результат: " + result);


            } else {

                int h = currentA.getValue();
                int f = currentC.getValue();
                int result2 = calcR(h, f, b);
                if ((h > 10) & (f > 10)) {
                    throw new ArithmeticException();
                }
                if (result2 < 1) {
                    throw new ArithmeticException();
                }

                for (Roman roman : Roman.values()) {
                    if (result2 == roman.hasCurrency()) {
                        System.out.println("Результат " + roman);
                    }

                }

            }
        }


        public static int calc ( int d, int g, String b){
            int result;
            switch (b) {
                case "+":
                    result = d + g;
                    break;
                case "-":
                    result = d - g;
                    break;
                case "*":
                    result = d * g;
                    break;
                case "/":
                    result = d / g;
                    break;
                default:

                    result = calc(d, g, b);
            }
            return result;
        }
        public static int calcR ( int h, int f, String b){
            int result2;
            switch (b) {
                case "+":
                    result2 = h + f;
                    break;
                case "-":
                    result2 = h - f;
                    break;
                case "*":
                    result2 = h * f;
                    break;
                case "/":
                    result2 = h / f;
                    break;
                default:

                    result2 = calcR(h, f, b);
            }
            return result2;
        }
    }
