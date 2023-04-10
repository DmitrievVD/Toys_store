import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static ArrayList<Toys> toysArr = new ArrayList<>();
    public static ArrayList<Toys> prizToys = new ArrayList<>();

    public static Scanner user_input = new Scanner(System.in);
    public static void main(String[] args) {
        Toys toys2 = new Toys("Мишка", 10, 10);
        Toys toys1 = new Toys("Робот", 15, 10);
        Toys toys3 = new Toys("Симпл", 20, 30);
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
                "get -> Получить игрушку";

        sort(toysArr);

        while (true){
            System.out.println(help);
            System.out.print("Введите команду: ");
            String in = user_input.nextLine();

            if (in.equals("read")){
                for (Toys toy : toysArr) {
                    System.out.println(toy.toString());
                }
            if (in.equals("add")){
                addToy();
            }
            if (in.equals("edit")){

            }


            user_input.nextLine();

            }
        }
    }

    static void sort(ArrayList<Toys> arr){
        arr.sort(new Comparator<Toys>() {
            @Override
            public int compare(Toys o1, Toys o2) {
                return (int) (o2.getRandom() - o1.getRandom());
            }
        });
    }

    static void addToy(){
        System.out.print("Введите название: ");
        String name = user_input.nextLine();
        System.out.print("Введите кол-во: ");
        int val = user_input.nextInt();
        System.out.print("Введите вес(%): ");
        double wt = user_input.nextDouble();
        Toys newtoy = new Toys(name, wt, val);
        toysArr.add(newtoy);
    }
}