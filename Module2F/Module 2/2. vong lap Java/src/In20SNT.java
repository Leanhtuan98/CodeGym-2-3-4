public class In20SNT {
    public static void main(String[] args) {
        int dem = 0 ;
        for (int a = 2; dem <=19 ; a++) {
            boolean snt = true;
            for (int i = 2; i <a ; i++) {
                if (a % i == 0 ) {
                    snt = false;
                }

            }
            if (snt == true) {
                dem ++;
                System.out.println(a);
            }

        }
    }
}
