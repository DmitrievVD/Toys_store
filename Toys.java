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

    public Toys getPrizeToy(ArrayList<Toys> arrToys) {
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
                    System.out.println("This toy is out of stock.");
                    return null;
                }
            }
        }
        return null;
    }

    public void savePrizeToyToFile(Toys prizeToy, String fileName){
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(prizeToy.getName() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred when saving prize toy to file.");
            e.printStackTrace();
        }
    }
}
