import java.util.Scanner;

public class Delete {
    public static void main(String[] args) {
        int daySo[] = {1,2,3,5,8};
        Scanner scanner = new Scanner(System.in);
        int soCanXoa = scanner.nextInt();
        int viTriCanXoa = timViTriPhanTu(daySo, soCanXoa);
        if ( viTriCanXoa== -1) {
            System.out.println("Phan tu khong o trong mang");
        } else {
            daySo = xoaMotPhanTu(daySo, viTriCanXoa);
        }
        for (int i = 0; i < daySo.length; i++) {
            System.out.println(daySo[i] + "\t");
        }
    }
    public static int timViTriPhanTu(int[] daySo, int phanTu) {
        int viTri = -1;
        for (int i = 0; i < daySo.length; i++) {
            if (daySo[i] == phanTu) {
                viTri = i;
            }
        }
        return viTri;
    }
    public static int[] xoaMotPhanTu(int[] daySo, int viTri) {
        int[] daySoMoi = new int[daySo.length-1];
        for (int i = 0; i < viTri; i++) {
            daySoMoi[i] = daySo[i];
        }
        for (int i = viTri + 1; i < daySo.length; i++) {
            daySoMoi[i-1] = daySo[i];
        }
        return daySoMoi;
    }
}
