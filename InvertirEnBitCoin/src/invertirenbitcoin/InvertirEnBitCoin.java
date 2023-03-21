package invertirenbitcoin;

import java.util.Scanner;

public class InvertirEnBitCoin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] arrPrices = input.split(" ");
        int counter = 0;
        boolean mayor = false;
        for (int i = 0; i < arrPrices.length; i++) {
            for (int j = i; j < arrPrices.length; j++) {
                if (Integer.parseInt(arrPrices[j]) > Integer.parseInt(arrPrices[i]))  {
                    mayor = true;
                    break;
                } else{
                    counter++;
                }
            }
            if (!mayor) {
                counter = 0;
            }
            if (i != arrPrices.length-1) {
                System.out.print(counter + " ");
            } else {
                System.out.print(counter);
            }
            counter = 0;
            mayor = false;
        }
    }
    
}
