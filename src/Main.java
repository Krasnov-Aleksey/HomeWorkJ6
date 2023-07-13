import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        Laptop lt1 = new Laptop(4,512, "Window","Red");
        Laptop lt2 = new Laptop(6,1024, "Linux","Green");
        Laptop lt3 = new Laptop(8,2048, "Window","Red");
        Laptop lt4 = new Laptop(2,512, "MacOS","Blue");
        Laptop lt5 = new Laptop(16,2048, "Window","White");
        Laptop lt6 = new Laptop(4,512, "MacOS","Red");
        Laptop lt7 = new Laptop(4,512, "MacOS","Red");

        laptopSet.add(lt1);
        laptopSet.add(lt2);
        laptopSet.add(lt3);
        laptopSet.add(lt4);
        laptopSet.add(lt5);
        laptopSet.add(lt6);
        laptopSet.add(lt7);

       // System.out.println(lt6.equals(lt7));

        for(Laptop laptop:laptopSet){
            System.out.println(laptop);
        }

        List<Laptop>laptopList = new ArrayList<>();
        for (Laptop laptop:laptopSet){
            if(laptop.ram==4){
                laptopList.add(laptop);
            }
        }
        System.out.println();
        for (Laptop laptop: laptopList){
            System.out.println(laptop);
        }
    }
}