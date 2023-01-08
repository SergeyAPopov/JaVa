import java.util.Scanner;

/**
ДЗ 1
3 задания реализовано в одном проекте.
Task1: 
нахождение суммы и произведения заданого числа. 
Task2
Простые числа до 1000 
Task3
Калькулятор с простейщими действиями: 
сложение 
вычитание 
умножение 
деление

 */
public class dz1 
{
    /**
     */
    public static void main( String[] args )
    {
        // Task1
        // Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
        System.out.println("Введите значение:");
        Scanner scanner = new Scanner (System.in );
        String number = scanner.nextLine();
        scanner.close();
        int count_summ = 1;
        int count_mult = 1;
        for (int i=1; i < Integer.valueOf(number)+1; i++){
            count_summ += i;
            count_mult *= i;    
        }        
        System.out.println("Сумма чисел: " + count_summ );
        System.out.println("Поизведение чисел: " + count_mult );

        // Task2
        // Вывести все простые числа от 1 до 1000
        for (int i = 1; i<1001;i++){
            int count = i;
            if (i==1){
                System.out.println(i);
            }
            else
                for (int j = 2; j < i;j++){
                    if (i % j == 0){
                    count = 0;
                    break;    
                    }
                }
            if (count != 0){
                System.out.println(i);
            }
        }

        // Task3
        // Реализовать простой калькулятор
        System.out.println("Введите первое значение:");
        Scanner scanner1 = new Scanner (System.in );
        String number_one = scanner1.nextLine();
        System.out.println("Введите второе значение:");
        Scanner scanner2 = new Scanner (System.in );
        String number_two = scanner2.nextLine();
        System.out.println("Выберите необходимое действие:\n 1 - суммирование  \n 2 - вычитание \n 3 - умножение \n 4 - деление");
        Scanner scanner3 = new Scanner (System.in );
        String action = scanner3.nextLine();
        scanner1.close();
        scanner2.close();
        scanner3.close();
        int solution = 0;

        if (Integer.valueOf(action) == 1){
            solution = Integer.valueOf(number_one) + Integer.valueOf(number_two);
            System.out.println("Решение: \n" + number_one + "+" + number_two + "=" + solution);
        }
        if (Integer.valueOf(action) == 2){
            solution = Integer.valueOf(number_one) - Integer.valueOf(number_two);
            System.out.println("Решение: \n" +  number_one + "-" + number_two + "=" + solution);
        }
        if (Integer.valueOf(action) == 3){
            solution = Integer.valueOf(number_one) * Integer.valueOf(number_two);
            System.out.println("Решение: \n" + number_one + "*" + number_two + "=" + solution);
        }
        if (Integer.valueOf(action) == 4){
            solution = Integer.valueOf(number_one) / Integer.valueOf(number_two);
            System.out.println("Решение: \n" + number_one + "/" + number_two + "=" + solution);
        }
    }
}
