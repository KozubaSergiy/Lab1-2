package river;

import java.util.Scanner;

class River
{
    String name;
    String location;
    double lenght;
}
class RecordRiver{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        // ВВОД ИНФЫ О РЕКАХ
        System.out.println("Введите количество рек: ");
        int number = sc.nextInt();
        River river[] = new River[number];
        System.out.println("Введите информацию о реках: ");
        for (int i = 0; i < river.length; i++)
        {
            sc.nextLine();
            river[i] = new River();
            System.out.print("Название "+(i+1+"-й реки: "));
            river[i].name = sc.nextLine();
            System.out.print("Место расположения "+(i+1+"-й реки: "));
            river[i].location = sc.nextLine();
            System.out.print("Длина "+(i+1+"-й реки (в км): "));
            river[i].lenght = sc.nextDouble();
        }


        //ВЫВОД ИНФЫ
        System.out.println("\nХарактеристики рек: ");
        for (int i = 0; i < river.length; i++)
        {
            System.out.println(""+river[i].name+"\t"+river[i].location+"\t"+river[i].lenght +" км");
        }

        //РЕКА С минимальной ДЛИНОЙ
        int nommin=0;
        double min = river[nommin].lenght;
        for (int i =0; i < river.length;i++)
            if (river[i].lenght < min)
            {
                min = river[i].lenght;
                nommin = i;
            }
        System.out.println("\nРека с минимальной длиной: ");
        System.out.println(""+river[nommin].name+"\t"+river[nommin].location+"\t"+river[nommin].lenght +" км");

        //СОРТИРОВКА РЕК ПО НАЗВАНИЮ
        for (int i = 0; i < river.length-1; i++)
        {
            for (int j = 0; j < river.length-i-1; j++)
            {
                if(river[j].name.compareTo(river[j+1].name)>0)
                {
                    River temp = river[j];
                    river[j]=river[j+1];
                    river[j+1]=temp;
                }
            }

        }

        System.out.println("\nОтсортированный список по названиям: ");
        for (int i = 0; i< river.length; i++)
        {
            System.out.println(""+river[i].name+"\t"+river[i].location+"\t"+river[i].lenght +" км");
        }

        //ДЛИНА БОЛЬШЕ СРЕДНЕЙ
        double l = 0;
        for (int i = 0;i< river.length; i++)
            l+=river[i].lenght;
        double avg = l/river.length;
        System.out.println("Средняя длина = " + avg);
        System.out.print("\nРеки, с длиной больше средней: ");
        for (int i = 0;i<river.length; i++)
        {
            if(river[i].lenght>avg)
                System.out.println(""+river[i].name+"\t"+river[i].location+"\t"+river[i].lenght +" км");
        }

        //МЕНЮ
        sc.nextLine();
        boolean STOP = false;
        while(!STOP)
        {
            System.out.println("\n\n\tВЫБЕРИТЕ ОДНУ ИЗ ФУНКЦИЙ");
            System.out.println("\n 'find' - поиск по названию, 'repair' - исправление поля, 'info' - вывод полной информации о реках, 'stop' - закончить работу программы");
            String text = sc.nextLine();
            switch (text) {
                case "find":
                    System.out.println("Введите название искомой реки: ");
                    String name = sc.nextLine();
                    int nom = -1;
                    for (int i = 0; i < river.length; i++)
                        if (name.equalsIgnoreCase(river[i].name))
                            nom = i;
                    if (nom != -1) {
                        System.out.println("Такая река есть в списке. Это " + river[nom].name + "\t" + river[nom].location + "\t" + river[nom].lenght + " км");
                    } else System.out.println("Такой реки нет в списке");
                    break;
                case "repair":
                    System.out.println("Введите название реки, поле которой хотите поменять: ");
                    name = sc.nextLine();
                    nom = -1;
                    boolean StopCaseRepair = false;
                    for (int i = 0; i < river.length; i++) {
                        if (name.equalsIgnoreCase(river[i].name))
                            nom = i;
                    }
                    if (nom == -1) {
                        System.out.println("Такой реки нет в списке");
                        StopCaseRepair = true;
                    }
                    else
                    {
                        System.out.println("Введите номер поля, которое хотите поменять");
                        System.out.println("\n 1 - Название, 2 - Место расположения, 3 - Длина");
                        int pole = sc.nextInt();
                        switch (pole) {
                            case 1:
                                System.out.println("Введите новое название: ");
                                sc.nextLine();
                                river[nom].name = sc.nextLine();
                                System.out.println("Название измененно!");
                                break;
                            case 2:
                                System.out.println("Введите новое место расположения: ");
                                sc.nextLine();
                                river[nom].location = sc.nextLine();
                                System.out.println("Место расположения измененно!");
                                break;
                            case 3:
                                System.out.println("Введите новую длину: ");
                                sc.nextLine();
                                river[nom].lenght = sc.nextDouble();
                                System.out.println("Длина изменена!");
                                break;
                        }
                    }
                    break;
                case "info":
                    System.out.println("Информация о реках: ");
                    for (int i = 0; i < river.length; i++) {
                        System.out.println("\n" + river[i].name + "\t" + river[i].location + "\t" + river[i].lenght + " км");
                    }
                    break;
                case "stop":
                    STOP = true;
                    break;
                default:
                System.out.println("Такой команды не существует!");
                break;

            }
        }
    }
}