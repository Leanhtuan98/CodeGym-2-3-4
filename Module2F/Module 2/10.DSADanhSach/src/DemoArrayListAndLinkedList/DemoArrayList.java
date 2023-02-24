package DemoArrayListAndLinkedList;

import java.util.ArrayList;

public class DemoArrayList {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();

        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Mec");
        cars.add("Kia");
        cars.add("Ranger");

        cars.set(2,"PLK");
        System.out.println(cars);
    }
}
