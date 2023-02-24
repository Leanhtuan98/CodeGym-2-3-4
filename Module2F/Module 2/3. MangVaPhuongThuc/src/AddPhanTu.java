public class AddPhanTu {
    public static int timViTriPhanTu(int[] daySo, int[] phanTu) {
        int viTri = -1;
        for (int i = 0; i < daySo.length; i++) {
            if (daySo[i] == phanTu) {
                viTri = i;
            }
        }
        return viTri;

    }

    public static int[] themPhanTuVaoDay(int[] daySo, int viTri) {
        int[] daySoMoi = new int[daySo.length + 1];
        for (int i = 0; i < daySo.length; i++) {
            daySoMoi[i] = daySo[i];
        }
        for (int i = viTri + 1; i < daySo.length; i++) {
            daySoMoi[i + 1] = daySo[i];
        }
        return daySoMoi;
    }


}
