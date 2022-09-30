import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");  //создание коллекции экземпляров
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10_000_000; i++) {  //список людей до 10млн.чел
            persons.add(new Person(  //добавляем людей в список
                    names.get(new Random().nextInt(names.size())),  //показатели будут случайные
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100), //создаем рандом:дай мне стартовое число чтобы я от него шагал
                    // в определенной последовательности, кот будет выглядеть как случайная, если ничего не выбирать
                    // будет текущее время и каждый раз при запуске будет новая последовательность
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        //Найти количество несовершеннолетних (т.е. людей младше 18 лет)
        List agePeople = new ArrayList<>(persons) //создаем новый список(кот можно менять)+копируем то, что было в старом списке
                .stream().filter(person -> .getAge < 18)  //промежуточный
                .count(); //термальный

        //Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
        List conscript = new ArrayList<>(persons)
                .stream().filter(person -> .getAge <= 27)
                .stream().filter(person -> .getAge >= 18)
                .map //для преобразования данных из Person в String (так как нужны только фамилии)
                .collect(Collectors.toList()); //получить список List<String>

        //Получить отсортированный по фамилии список потенциально работоспособных людей с высшим
        //образованием в выборке (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).
        List workable = new ArrayList<>(persons)
                .stream().filter(person -> )  //высшее образование
                .stream().filter(person -> .getAge <= 65)  //возраст
                .stream().filter(person -> .getAge >= 18)
                .sorted()
                .collect(Collectors.toList());  //получить список
    }
}
