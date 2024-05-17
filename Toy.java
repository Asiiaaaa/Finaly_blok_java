import java.util.PriorityQueue;
import java.util.Random;

public class Toy {
    private int id;
    private String name;
    private int weight;

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return this.id;
    }

    public int getWeight() {
        return this.weight;
    }

    public String toString() {
        return "Toy{id=" + id + ", name='" + name + "', weight=" + weight + "}";
    }

    public static void main(String[] args) {
        Toy[] toyArray = new Toy[3];
        toyArray[0] = new Toy(1, "конструктор", 2);
        toyArray[1] = new Toy(2, "робот", 2);
        toyArray[2] = new Toy(3, "кукла", 6);

        PriorityQueue<Toy> toyQueue = new PriorityQueue<>(toyArray.length, 
                (t1, t2) -> t2.getWeight() - t1.getWeight());

        for (Toy toy : toyArray) {
            toyQueue.add(toy);
        }

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(10);
            Toy drawnToy = null;

            if (randomNumber < 2) {
                drawnToy = toyQueue.poll();
            }
            if (drawnToy != null) {
                System.out.println("Выпавшая игрушка: " + drawnToy);
                // Запись результатов в файл можно добавить здесь
            } else {
                System.out.println("Не удалось определить игрушку");
            }
        }
    }
}
