package ke_thua;

// ke thua thong qua tu khoa extends + class

public class AnThit extends Animal{
    // van co the viet them cac thuoc tinh va phuong thuc o day.
    private String loaiThit;
    public void diSan() {
        System.out.println("rinh moi");
    }

    // day la constructor 1 tham so

//    public AnThit(String loaiThit) {
//        this.loaiThit = loaiThit;
//    }

    // day la constructor 0 tham so

//    public AnThit() {
//
//        // super() tuong trung cho class cha. () goi den constructor cua class cha
//        // lop con goi constructor 2 tham so cua lop cha
//        // neu ko ghi gi thi mac dinh la super() se goi den constructor ko tham so cua class cha
//        super("bao",10);
//
//    }
    // phương thức ăn của lớp cha là ăn cỏ, nhưng phương thức ăn của lớp con lại là ăn thịt nên phải thay đổi phương thức ăn từ ăn cỏ thành ăn thịt.
    // b1: ghi lại phương thức ăn của class bằng cách viết trong lớp con sử dụng super.eat().
    // Override là phương thức ghi đè
    // header của phương thức ghi đè phải giống hệt class cha, còn accsecmofider thì phải lớn hơn hoặc bằng.


    @Override
    public void eat() {
//        super.eat();
        System.out.println("an thit");
    }
}
