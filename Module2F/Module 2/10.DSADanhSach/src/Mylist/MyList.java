package Mylist;

import java.util.Arrays;

public class MyList <E> {
    //Tạo lớp Mylist.MyList với các thuộc tính như mô tả.
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Cài đặt phương thức ensureCapa()
    // Mục đích: Tăng gấp đôi kích thước mảng chứa các phần tử

    private void ensureCapa() {
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements,newSize);
    }

    // Cài đặt phương thức add()
    // Mục đích: thêm một phần tử vào cuối danh sách, tham số đầu vào: Phần tử cần thêm vào danh sách.

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    // Cài đặt phương thức get()
    // Mục đích: phương thức get() trả về phần tử ở vị trí thứ i trong danh sách.

    public E get(int i) {
        if (i>= size || i<0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size" + i);
        }
        return (E) elements[i];
    }

    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);
        listInteger.add(6);

        System.out.println("element 4: "+listInteger.get(4));
        System.out.println("element 1: "+listInteger.get(1));
        System.out.println("element 2: "+listInteger.get(2));


//        listInteger.get(6);
//        System.out.println("element 6: "+listInteger.get(6));

    }
}
