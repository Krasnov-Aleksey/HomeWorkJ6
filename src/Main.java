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
        Map menuMap = new HashMap<>();


        menu(laptopList,laptopSet,menuMap);

    }
    static void menu(List<Laptop> laptopList, Set<Laptop> laptopSet,Map menuMap){

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
                    menuMap.put(choice,scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Введите размер ЖД");
                    menuMap.put(choice,scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Введите название операционной системы");
                    menuMap.put(choice,scanner.next());
                    break;
                case 4:
                    System.out.println("Введите цвет");
                    menuMap.put(choice,scanner.next());
                    break;
                case 5:
                    //System.out.println(menuMap);
                    filter(laptopList,laptopSet,menuMap);
                    flag=false;
                    break;
            }
        }
    }
    static void filter(List<Laptop> laptopList, Set<Laptop> laptopSet,Map menuMap){
//        for(Laptop laptop:laptopList){
//            if(laptop.ram>=(int)menuMap.get(1)&&laptop.hdd>=(int)menuMap.get(2)
//            && laptop.operatingSystem.equalsIgnoreCase((String) menuMap.get(3))&&
//            laptop.color.equalsIgnoreCase((String) menuMap.get(4))){
//                laptopSet.add(laptop);
//            }
//        }
        Set <Laptop> mapFilter1 = new HashSet();
        Set <Laptop> mapFilter2 = new HashSet();
        Set <Laptop> mapFilter3 = new HashSet();
        Set <Laptop> mapFilter4 = new HashSet();

        if (menuMap.containsKey(1)){
            for (Laptop laptop:laptopList){
                if (laptop.ram>=(int)menuMap.get(1)){
                    mapFilter1.add(laptop);
                }
            }
        }
        if (menuMap.containsKey(2)){
            for (Laptop laptop:laptopList){
                if (laptop.hdd>=(int)menuMap.get(2)){
                    mapFilter2.add(laptop);
                }
            }
        }
        if(menuMap.containsKey(3)){
            for(Laptop laptop:laptopList){
                if(laptop.operatingSystem.equalsIgnoreCase((String) menuMap.get(3))){
                    mapFilter3.add(laptop);
                }
            }
        }

        if (menuMap.containsKey(4)){
            for (Laptop laptop:laptopList){
                if (laptop.color.equalsIgnoreCase((String) menuMap.get(4))){
                    mapFilter4.add(laptop);
                }
            }
        }

        if(!mapFilter1.isEmpty()){
            laptopSet.addAll(mapFilter1);
            if(!mapFilter2.isEmpty()){
                laptopSet.retainAll(mapFilter2);
            }
            if(!mapFilter3.isEmpty()){
                laptopSet.retainAll(mapFilter3);
            }
            if(!mapFilter4.isEmpty()){
                laptopSet.retainAll(mapFilter4);
            }
        } else if (!mapFilter2.isEmpty()) {
            laptopSet.addAll(mapFilter2);
            if(!mapFilter3.isEmpty()){
                laptopSet.retainAll(mapFilter3);
            }
            if(!mapFilter4.isEmpty()){
                laptopSet.retainAll(mapFilter4);
            }
        } else if (!mapFilter3.isEmpty()) {
            laptopSet.addAll(mapFilter3);
            if(!mapFilter4.isEmpty()){
                laptopSet.retainAll(mapFilter4);
            }
        } else if (!mapFilter4.isEmpty()) {
            laptopSet.addAll(mapFilter4);
        }



//        mapFilter1.retainAll(mapFilter2);
//        mapFilter1.retainAll(mapFilter3);
//        laptopSet.retainAll(mapFilter3);
//        laptopSet.retainAll(mapFilter4);

//        for(Laptop laptop:mapFilter1){
//            System.out.println(laptop);
//        }
//        System.out.println();
//
//        for(Laptop laptop:mapFilter2){
//            System.out.println(laptop);
//        }
//        System.out.println();

        if(!laptopSet.isEmpty()){
            for (Laptop laptop:laptopSet){
                System.out.println(laptop);
            }
        }
        else {
            System.out.println("Ноутбук с параметрами "+menuMap+" не найден" );
        }
    }
}