

import java.util.ArrayList;
import java.util.Scanner;

public class Dz6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp866");

        ArrayList<Notebook> notebook = new ArrayList<>();
        Notebook note1 = new Notebook("Lenovo IdeaPad 3 Gen 5", 8, 500, "no OS", 40990 , "Gray");
        notebook.add(note1);
        Notebook note2 = new Notebook("Lenovo IdeaPad 3 15ABA7", 16, 750, "no OS", 54790 , "Gray");
        notebook.add(note2);
        Notebook note3 = new Notebook("Lenovo Legion 5 Pro Gen 7", 16, 1000, "no OS", 167290 , "Storm Grey");
        notebook.add(note3);
        Notebook note4 = new Notebook("HUAWEI MateBook", 16, 512, "Windows 11 Home", 49990 , "Silver");
        notebook.add(note4);
        Notebook note5 = new Notebook("HUAWEI MateBook", 16, 256, "Windows 11 Home", 38999 , "Silver");
        notebook.add(note5);
        Notebook note6 = new Notebook("Acer Extensa ", 8, 512, "Windows 10", 43190 , "Black");
        notebook.add(note6);

        System.out.println("Перечень ноутбуков: ");
        System.out.println(notebook);

        Notebook check = new Notebook("no", 0, 0, "no", 0, "no");       
        while (true) {
            System.out.println("Введите цифру необходимого критерия:\n 0 - модель\n 1 - объем ОЗУ\n 2 - объем HDD\n 3 - ОС \n 4 - цена \n 5 - цвет \n 6 - выход");
            String str = sc.nextLine();

            if (str.equals("0")) {
                System.out.println("Введите название модели: ");
                String str0 = sc.nextLine();
                check.setmodel(str0);
            }
            if (str.equals("1")) {
                System.out.println("Введите необходимый объем ОЗУ, Гб: ");
                String str1 = sc.nextLine();
                int number1 = Integer.valueOf(str1);
                check.setram(number1);
            }
            if (str.equals("2")) {
                System.out.println("Введите необходимый объем HDD, Гб: ");
                String str2 = sc.nextLine();
                int number2 = Integer.valueOf(str2);
                check.sethdd(number2);
            }
            if (str.equals("3")) {
                System.out.println("Введите OS : ");
                String str3 = sc.nextLine();
                check.setos(str3);
            }
            if (str.equals("4")) {
                System.out.println("Введите необходимую цену: ");
                String str4 = sc.nextLine();
                int number4 = Integer.valueOf(str4);
                check.setprice(number4);
            }
            if (str.equals("5")) {
                System.out.println("Введите необходимый цвет: ");
                String str5 = sc.nextLine();
                check.setcolor(str5);
            }
            if (str.equals("6")) {
                break;
            }
        }
        
        System.out.println(check);

        ArrayList<Notebook> res = new ArrayList<Notebook>();

        for (Notebook notebooks : notebook) {
            if (check.getmodel().equals("no") || check.getmodel().equals(notebooks.getmodel())) {
                if (check.getram() == 0 || check.getram() <= notebooks.getram()) {
                    if (check.gethdd() == 0 || check.gethdd() <= notebooks.gethdd()) {
                        if (check.getos().equals("no") || check.getos().equals(notebooks.getos())) {
                            if (check.getprice() == 0 || check.getprice() >= notebooks.getprice()) {
                                if (check.getcolor().equals("no") || check.getcolor().equals(notebooks.getos())) {
                                    res.add(notebooks);
                                    }
                                    else {
                                    continue;
                                    }
                                }
                                else {
                                    continue;
                                }

                            }
                            else {
                                continue;
                            }
                        }
                        else {
                            continue;
                        }
                    }
                    else {
                        continue;
                    }
                }
                else {
                    continue;
                }
            }

        if (res.isEmpty())
        {
            System.out.println("соответствующих нет");
        } else {
            System.out.println(res);
        }
    sc.close();
    }
}

