import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Toys {
    private int id;
    private static int count = 0;
    private int volume;
    private String name;

   private double random;

    public Toys(String name, double random, int volume) {
        this.id = count;
        count += 1;
        this.name = name;
        this.random = random;
        this.volume = volume;
    }

    public int getId() {
        return id;
    }

    public int getVolume(){
        return volume;
    }
    public void setVolume(int volume){
        this.volume = volume;
    }

    public static String setName() { // Дать случайное имя
        return String.valueOf(NameToys.values()[new Random().nextInt(NameToys.values().length - 1)]);
    }

    public String getName(){
        return name;
    }

    public double getRandom(){
        return random;
    }

    public void setRandom(double random) {
        this.random = random;
    }
    @Override
    public String toString() {
        return getId() + " | " + getName() + " | кол-во: " + getVolume() + " | вес(%): " + getRandom();
    }

    public static int getSizeToys(ArrayList<Toys> arrToys){
        int res = 0;
        for (Toys t : arrToys) {
            res += t.getVolume();
        }
        return res;
    }

    static public Toys getPrizeToy(ArrayList<Toys> arrToys) { // Получение игрушки рандомным способом
        double totalFreq = 0.0;
        for (Toys t : arrToys) {
            totalFreq += t.getRandom();
        }
        double rn = Math.random() * totalFreq;
        double freqSum = 0.0;

        for (Toys t : arrToys) {
            freqSum += t.getRandom();
            if (freqSum >= rn) {
                if (t.getVolume() > 0) {
                    t.setVolume(t.getVolume() - 1);
                    return t;
                } else {
                    System.out.println("Игрушки закончились :(");
                    return null;
                }
            }
        }
        return null;
    }

    static public void savePrizeToyToFile(ArrayList<String> prizeToy, String fileName){ // Сохранение игрушки в фаил
        try {
            FileWriter fw = new FileWriter(fileName, true);
            if (prizeToy.size() > 0) {
                fw.write(prizeToy.get(0).toString() + "\n");
                System.out.println("Вы получили: " + prizeToy.get(0).toString());
                prizeToy.remove(0);
                fw.close();
            }else{
                System.out.println("Ваш список призовых игрушек пуст :(");
            }

        } catch (IOException e) {
            System.out.println("Ошибка при сохранении!");
            e.printStackTrace();
        }
    }
}
