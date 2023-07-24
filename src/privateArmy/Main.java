package privateArmy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Mercenary> mercenaries = new ArrayList<>();

        mercenaries.add(new Mercenary("Artem", 33, SpecializationEnum.COMANDOR, 1000));
        mercenaries.add(new Mercenary("Kate", 30, SpecializationEnum.SNAIPER, 324));
        mercenaries.add(new Mercenary("Denis", 12, SpecializationEnum.CANONEER, 12345));
        mercenaries.add(new Mercenary("Egor", 10, SpecializationEnum.CANONEER, 6574));
        mercenaries.add(new Mercenary("Olga", 59, SpecializationEnum.CANONEER, 778798));
        mercenaries.add(new Mercenary("Ilya", 1, SpecializationEnum.DRIVER, 10));

        /*System.out.println(mercenaries.stream().filter(mercenary -> mercenary.getAge() > 20).count());
        System.out.println(mercenaries
                .stream()
                .filter(m -> m.getSpecialization().equals(SpecializationEnum.CANONEER))
                .map(merc -> merc.getSalary())
                .reduce((sal1, sal2) -> sal1 + sal2).get());

        List<Person> personList = mercenaries
                .parallelStream()
                .map(merc -> new Person(merc.getName(), merc.getAge()))
                .collect(Collectors.toList());
        System.out.println(personList);

        Mercenary older = mercenaries.stream().max((m1, m2) -> m1.getAge() - m2.getAge()).get();
        System.out.println(older);

        mercenaries
                .stream()
                .filter(m -> m.getSpecialization().equals(SpecializationEnum.CANONEER))
                .map(merc -> merc.getSalary())
                .forEach(cont -> System.out.println(cont));*/

        //Всех наемников в алфавитном порядке, у которых специализация не командир- убавить им зп на 1000 и вывести на консоль
        List<Mercenary> personList2 = mercenaries
                .stream()
                .filter(mercenary -> !mercenary.getSpecialization().equals(SpecializationEnum.COMANDOR))
                .map(mercenary -> new Mercenary(mercenary.getName(),
                        mercenary.getAge(),
                        mercenary.getSpecialization(),
                        mercenary.getSalary() -1000))
                .sorted(Comparator.comparing(Mercenary::getName))
                .collect(Collectors.toList());
        System.out.println(personList2);

        //группировать наемников по величине зп и вывести на экран отдельно. (от 1 до 1000, от 1000 до 10000, от 17000)
        Map<String, List<Mercenary>> salaryGroups = mercenaries.stream()
                .collect(Collectors.groupingBy(mercenary -> {
                    double salary = mercenary.getSalary();
                    if (salary <= 1000) {
                        return "от 1 до 1000";
                    } else if (salary <= 10000) {
                        return "от 1000 до 10000";
                    } else {
                        return "больше 10000";
                    }
                }));

        salaryGroups.forEach((range, mercenaryList) -> {
            System.out.println("Зп " + range + ":");
            mercenaryList.forEach(System.out::println);
            System.out.println();
        });


        //Вывести на экран пары Наемник-Человек, где ключом будет общее имя
        Map<String, Person> mercenaryPersonMap = mercenaries.stream()
                .collect(Collectors.toMap(Mercenary::getName, mercenary -> new Person(mercenary.getName(),
                        (mercenary.getAge()))));
        System.out.println("");
        mercenaryPersonMap.forEach((name, person) -> System.out.println(name + " - " + person));

    }

}
