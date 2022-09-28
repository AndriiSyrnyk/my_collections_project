import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyCollectionsTest {
    public static void main(String[] args) {
        //myLinkingListTest();
        //myArrayListTest();
        //myQueueTest();
        myHashMapTest();
        //myStackTest();
    }

    private static void myStackTest() {
        //MyStack<String> cars = new MyStack<>();
        Stack<String> cars = new Stack<>();
        cars.push("Opel");
        cars.push("Seat");
        cars.push("DS");
        cars.push("Alfa Romeo");
        cars.push("Skoda");
        cars.push("Citroen");

        System.out.println(cars.size());
        System.out.println("peek(): " + cars.peek());
        System.out.println("pop(): " + cars.pop());
        System.out.println("pop(): " + cars.pop());
        System.out.println("pop(): " + cars.pop());
        System.out.println("pop(): " + cars.pop());
    }

    private static void myHashMapTest() {
        MyHashMap<String, Integer> citiesPopulation = new MyHashMap<>();
        citiesPopulation.put("Kyiv", 3000);
        citiesPopulation.put("Kyiv", 3100);
        citiesPopulation.put("Lviv", 800);
        citiesPopulation.put("Ternopil", 250);
        citiesPopulation.put("Odesa", 1000);
        citiesPopulation.put("Ternopil", 230);
        citiesPopulation.put("Rivne", 250);
        citiesPopulation.put("Lutsk", 220);
        citiesPopulation.put("Vinnytsya", 350);
        citiesPopulation.put("Cherkasy", 300);
        citiesPopulation.put("Brovary", 100);
        citiesPopulation.put("Sumy", 300);
        citiesPopulation.put("Khmelnytskyy", 280);
        citiesPopulation.put("Dnipro", 1000);
        citiesPopulation.put("Chernivtsi", 270);
        citiesPopulation.put("Irpin", 100);
        citiesPopulation.put("Uman", 100);
        citiesPopulation.put("Kryvyy Rih", 650);
        citiesPopulation.put("Kharkiv", 1700);
        citiesPopulation.put("Mukachevo", 90);
        citiesPopulation.put("Uzhorod", 120);
        citiesPopulation.put("Zaporizjya", 750);
        citiesPopulation.put("Bila Tserkva", 200);
        citiesPopulation.put("Drohobych", 120);
        citiesPopulation.put("Chortkiv", 30);
        System.out.println(citiesPopulation);
        System.out.println(citiesPopulation.size());
        citiesPopulation.remove("Rivne");
        citiesPopulation.remove("Cherkasy");
        citiesPopulation.remove("Ternopil");
        citiesPopulation.remove("Uzhorod");
        System.out.println(citiesPopulation);
        System.out.println(citiesPopulation.size());
        citiesPopulation.put("Rivne", 250);
        citiesPopulation.put("Cherkasy", 300);
        citiesPopulation.put("Ternopil", 230);
        citiesPopulation.put("Uzhorod", 120);
        System.out.println(citiesPopulation);
        System.out.println(citiesPopulation.size());

        System.out.println("Ternopil: " + citiesPopulation.get("Ternopil"));
        System.out.println("Mukachevo: " + citiesPopulation.get("Mukachevo"));
        System.out.println("Cherkasy: " + citiesPopulation.get("Cherkasy"));
        System.out.println("Uman: " + citiesPopulation.get("Uman"));
        System.out.println("Kryvyy Rih: " + citiesPopulation.get("Kryvyy Rih"));
        System.out.println("Odesa: " + citiesPopulation.get("Odesa"));
        System.out.println("Odessa: " + citiesPopulation.get("Odessa"));
        System.out.println("Zaporizjya: " + citiesPopulation.get("Zaporizjya"));
        System.out.println("Uzhorod: " + citiesPopulation.get("Uzhorod"));
        System.out.println("Kharkiv: " + citiesPopulation.get("Kharkiv"));
        System.out.println("Dnipro: " + citiesPopulation.get("Dnipro"));
        System.out.println("Lutsk: " + citiesPopulation.get("Lutsk"));
        System.out.println("Kyiv: " + citiesPopulation.get("Kyiv"));
        System.out.println("Rivne: " + citiesPopulation.get("Rivne"));
        System.out.println("Brovary: " + citiesPopulation.get("Brovary"));
        System.out.println("Vinnytsya: " + citiesPopulation.get("Vinnytsya"));
        citiesPopulation.clear();
        System.out.println(citiesPopulation);
        System.out.println(citiesPopulation.size());
    }

    private static void myQueueTest() {
        MyQueue<String> cars = new MyQueue<>();
        //Queue<String> cars = new LinkedList<>();

        cars.add("Opel");
        cars.add("Seat");
        cars.add("DS");
        cars.add("Alfa Romeo");
        cars.add("Skoda");
        System.out.println(cars.size());
        //System.out.println(cars.size());
        //System.out.println(cars.peek());
        System.out.println(cars.poll());
        System.out.println(cars.poll());
        System.out.println(cars.poll());
        System.out.println(cars.poll());
        System.out.println(cars.poll());
        System.out.println(cars.poll());
    }

    private static void myLinkingListTest() {
        MyLinkedList<String> cars = new MyLinkedList<String>();

        cars.add("Opel");
        cars.add("Seat");
        cars.add("Skoda");
        cars.add("DS");
        cars.add("Alfa Romeo");
        cars.add("Toyota");
        cars.add("Chevrolet");
        //cars.clear();
        System.out.println("cars size:" + cars.size());
        System.out.println("cars[0]: " + cars.get(0));
        System.out.println("cars[1]: " + cars.get(1));
        System.out.println("cars[2]: " + cars.get(2));
        System.out.println("cars[3]: " + cars.get(3));
        System.out.println("cars[4]: " + cars.get(4));
        System.out.println("cars[5]: " + cars.get(5));
        System.out.println("cars[6]: " + cars.get(6));
        cars.remove(3);
        System.out.println("cars[0]: " + cars.get(0));
        System.out.println("cars[1]: " + cars.get(1));
        System.out.println("cars[2]: " + cars.get(2));
        System.out.println("cars[3]: " + cars.get(3));
        System.out.println("cars[4]: " + cars.get(4));
        System.out.println("cars[5]: " + cars.get(5));

    }

    private static void myArrayListTest() {
        MyArrayList<String> cars = new MyArrayList<>();
        cars.add("Opel");
        cars.add("Seat");
        cars.add("DS");
        cars.add("Alfa Romeo");

        for (int i = 0; i < cars.size(); i++) {
            System.out.print(cars.get(i) + " ");
        }
    }
}
