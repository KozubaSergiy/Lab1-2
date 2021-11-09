package river;

import java.util.Scanner;

class River
{
    String name;
    String location;
    double lenght;
}




class RecordRiver{
    static Scanner sc = new Scanner(System.in, "cp1251");




    public static void main(String[] args) {

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
        Info(river);




        //РЕКА С минимальной ДЛИНОЙ
        MinLenght(river);



        //СОРТИРОВКА РЕК ПО НАЗВАНИЮ
        Sort(river);
        System.out.println("\nОтсортированный список по названиям: ");
        Info(river);


        //ДЛИНА БОЛЬШЕ СРЕДНЕЙ

        Average(river);


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
                    int nom = FindRiver(river);
                    if (nom != -1) {
                        System.out.println("Такая река есть в списке. Это " + river[nom].name + "\t" + river[nom].location + "\t" + river[nom].lenght + " км");
                    } else System.out.println("Такой реки нет в списке");
                    break;
                case "repair":
                    System.out.println("Введите название реки, поле которой хотите поменять: ");
                    nom = FindRiver(river);
                    if (nom == -1) {
                        System.out.println("Такой реки нет в списке");
                    }
                    else
                    {
                        System.out.println("Введите номер поля, которое хотите поменять");
                        System.out.println("\n 1 - Название, 2 - Место расположения, 3 - Длина");
                        Repair(river, nom);
                    }
                    break;
                case "info":
                    System.out.println("Информация о реках: ");
                    Info(river);
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

    public static void Info (River[] river) // ВЫВОД ИНФЫ
    {

        for (int i = 0; i < river.length; i++)
        {
            System.out.println(""+river[i].name+"\t"+river[i].location+"\t"+river[i].lenght +" км");
        }

        return;
    }

    public static void MinLenght (River[] river) // ПОИСК МИНИМАЛЬНОЙ ДЛИНЫ
    {
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
        return;
    }

    public static void Sort (River[] river) // СОРТИРОВКА
    {
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
        return;
    }

    public static void Average (River[] river) // ПОИСК РЕК С ДЛИНОЙ, БОЛЬШЕЙ СРЕДНЕЙ
    {
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
        return;
    }

    public static int FindRiver (River[] river) // ПОИСК РЕКИ
    {
        String name = sc.nextLine();
        int nom = -1;
        for (int i = 0; i < river.length; i++)
            if (name.equalsIgnoreCase(river[i].name))
                nom = i;
        return nom;
    }

    public static void Repair (River[] river, int nom) // ИСПРАВЛЕНИЕ ПОЛЯ
    {
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
        return;
    }
}