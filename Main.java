import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static ArrayList<Toys> toysArr = new ArrayList<>();
    public static ArrayList<String> prizToys = new ArrayList<>();

    public static Scanner user_input = new Scanner(System.in);
    public static void main(String[] args) {
        Toys toys2 = new Toys("Мишка", 10, 5);
        Toys toys1 = new Toys("Робот", 15, 5);
        Toys toys3 = new Toys("Симпл", 20, 5);
        System.out.println();

        System.out.print("Press Enter to begin.");
        user_input.nextLine();
        toysArr.add(toys1);
        toysArr.add(toys2);
        toysArr.add(toys3);
        String help = "Навигация по меню: \n" +
                "read -> Посмотреть список\n" +
                "add -> Добавить игрушку\n" +
                "edit -> Изменить вес\n" +
                "priz -> Выйграть игрушку\n" +
                "prizList -> Посмотреть выйгрышь\n" +
                "get -> Получить игрушку\n" +
                "exit -> выйти";

        sort(toysArr);

        while (true){
            System.out.println(help);
            System.out.print("Введите команду: ");
            String in = user_input.nextLine();

            if (in.equals("read")) {
                for (Toys toy : toysArr) {
                    System.out.println(toy.toString());
                }
            }
            else if (in.equals("add")){
                addToy();
            }
            else if (in.equals("edit")){
                editToy();
            }
            else if (in.equals("priz")){
                if (Toys.getSizeToys(toysArr) > 0){
                    Toys toyPriz = Toys.getPrizeToy(toysArr);
                    System.out.println("Вы выйграли: " + toyPriz.getName());
                    prizToys.add(toyPriz.getName());
                }else {
                    System.out.println("Игрушки закончились :(");
                }

            }
            else if (in.equals("prizList")){
                for (String prizToy : prizToys) {
                    System.out.println(prizToy.toString());
                }
            }
            else if (in.equals("get")) {
                Toys.savePrizeToyToFile(prizToys, "C:\\Users\\pc\\Downloads\\Lesson_09\\ToyStore\\src\\main\\java\\priz.txt");
            }
            else if (in.equals("exit")){
                break;
            }
            user_input.nextLine();
            }
        System.out.println("--------------------------");
        System.out.println("---Завершение программы---");
        System.out.println("--------------------------");
        }

    static void sort(ArrayList<Toys> arr){ // Сортировка по весу(%)
        arr.sort(new Comparator<Toys>() {
            @Override
            public int compare(Toys o1, Toys o2) {
                return (int) (o2.getRandom() - o1.getRandom());
            }
        });
    }

    static void addToy(){ // Добавление игрушки
        System.out.print("Введите название: ");
        String name = user_input.nextLine();
        System.out.print("Введите кол-во: ");
        int val = user_input.nextInt();
        System.out.print("Введите вес(%): ");
        double wt = user_input.nextDouble();
        Toys newtoy = new Toys(name, wt, val);
        toysArr.add(newtoy);
        sort(toysArr);
    }

    static void editToy(){ // Изменение веса игрушки
        System.out.print("Введите id: ");
        int i = user_input.nextInt();
        for (Toys toy: toysArr) {
            if (toy.getId() == i){
                System.out.print("Введите вес(%): ");
                double val = user_input.nextDouble();
                toy.setRandom(val);
                sort(toysArr);
                System.out.println("Изменения сохранены ");
                return;
            }
        }
        System.out.println("Нету такой!!!");
    }
}