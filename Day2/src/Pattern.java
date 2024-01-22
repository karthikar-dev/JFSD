import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {

        for (int i=0; i<5; i++) {
            for (int j=5; j>=1; j--) {
                if ((i+j) > 5)
                    System.out.print(j + " ");
                else
                    System.out.print((5 - i)+ " ");
            }
            System.out.println();
        }

    }
}
