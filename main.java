import java.io.IOException;
import java.util.Scanner;
public class main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическую операцию через пробел");
        String[] mas = new String[3];
        mas = scanner.nextLine().split(" ");
        String a = mas[0];
        String b = mas[1];
        String c = mas[2];
        int v = mas.length;
        if (v < 4) {
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
                if ((d < 11) & (g < 11)) {
                    if (b.equals("+")) {
                        System.out.println("Результат " + (d + g));
                    } else if (b.equals("-")) {
                        System.out.println("Результат " + (d - g));
                    } else if (b.equals("/")) {
                        System.out.println("Результат " + (d / g));
                    } else if (b.equals("*")) {
                        System.out.println("Результат " + (d * g));
                    }
                    else {
                        System.out.println("такого знака арифметической операции нет в базе");
                    }
                } else {
                    System.out.println("Калькулятор должен принимать на вход числа от 1 до 10 включительно");
                }
            } else {
                int y = 0;
                if ((currentA.getValue() < 11) & (currentC.getValue() < 11)) {
                    if (b.equals("+")) {
                        y = currentA.getValue() + currentC.getValue();
                    } else if (b.equals("-")) {
                        y = currentA.getValue() - currentC.getValue();
                    } else if (b.equals("/")) {
                        y = currentA.getValue() / currentC.getValue();
                    } else if (b.equals("*")) {
                        y = currentA.getValue() * currentC.getValue();
                    }
                    if (y<1){
                        System.out.println("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
                    }
                    for (Roman roman : Roman.values()) {
                        if (y == roman.hasCurrency()) {
                            System.out.println("Результат "+ roman);
                        }

                    }

                }
                else {
                System.out.println("Калькулятор должен принимать на вход числа от I до X включительно");
            }
            }
        }
    }
}