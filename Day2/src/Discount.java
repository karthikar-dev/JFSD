import java.util.Scanner;

public class Discount {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        float price = 0;

        if (amount > 1000)
            price = (amount*20)/100;
        else if (amount >= 500)
            price = (amount*10)/100;
        else
            price = amount;

        System.out.println(price);
    }
}
