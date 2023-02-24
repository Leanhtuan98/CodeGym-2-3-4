package ThemSuaXoa;

public class ManagerNumber {
    static int[] numbers = new int[0];

    public static void add(int num) {
        int[] newArr = new int[numbers.length + 1];
        for (int i = 0; i < numbers.length; i++) {
            newArr[i] = numbers[i];
        }
        newArr[newArr.length-1]=num;
        numbers = newArr;
    }
    public static void show(){
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + "  ");

        }
    }
}
