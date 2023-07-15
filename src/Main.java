import java.util.*;

public class Main {
/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например:
Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
Работу сдать как обычно ссылкой на гит репозиторий
Частые ошибки:
1. Заставляете пользователя вводить все существующие критерии фильтрации
2. Невозможно использовать более одного критерия фильтрации одновременно
3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики ноутбуков или добавить еще
 ноутбук, то программа начинает работать некорректно
 */

    public static void main(String[] args) {

        Set<Laptop> laptopSet = new HashSet<>();

        Laptop lt1 = new Laptop(4,512, "Windows","Red");
        Laptop lt2 = new Laptop(6,1024, "Linux","Green");
        Laptop lt3 = new Laptop(8,2048, "Windows","Red");
        Laptop lt4 = new Laptop(2,512, "MacOS","Blue");
        Laptop lt5 = new Laptop(16,2048, "Windows","White");
        Laptop lt6 = new Laptop(4,512, "MacOS","Red");


        List<Laptop> laptopList = new ArrayList<>();
        laptopList.add(lt1);
        laptopList.add(lt2);
        laptopList.add(lt3);
        laptopList.add(lt4);
        laptopList.add(lt5);
        laptopList.add(lt6);

        menu(laptopList,laptopSet);
    }
    static void menu(List<Laptop> laptopList, Set<Laptop> laptopSet){

        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("5 - Выйти из меню");
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        while (flag){

            System.out.println("Введите цифру, соответствующую необходимому критерию ");
            Integer choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Введите размер ОЗУ");
                    Integer text1 = scanner.nextInt();
                    for (Laptop laptop:laptopList)
                        if (laptop.ram>=text1){
                            laptopSet.add(laptop);
                        }
                    break;
                case 2:
                    System.out.println("Введите размер ЖД");
                    Integer text2 = scanner.nextInt();
                    for (Laptop laptop:laptopList)
                        if (laptop.hdd>=text2){
                            laptopSet.add(laptop);
                        }
                    break;
                case 3:
                    System.out.println("Введите название операционной системы");
                    String text3 = scanner.next();
                    for (Laptop laptop:laptopList)
                        if (laptop.operatingSystem.equalsIgnoreCase(text3)){
                            laptopSet.add(laptop);
                        }

                    break;
                case 4:
                    System.out.println("Введите цвет");
                    String text4 = scanner.next();
                    for (Laptop laptop:laptopList)
                        if (laptop.color.equalsIgnoreCase(text4)){
                            laptopSet.add(laptop);
                        }
                    break;
                case 5:
                    for (Laptop laptop: laptopSet) {
                        System.out.println(laptop);
                    }
                    flag=false;
                    break;
            }
        }
    }
}