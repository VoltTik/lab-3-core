package listOfProducts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int size = 5;
        Scanner scanner = new Scanner(System.in);
        String[] masOfProducts = new String[5];
        Integer[] masOfCosts = new Integer[5];
        Integer[] masOfCounts = new Integer[5];
        int count = 0;
        while (scanner.hasNext() && count < size) {
            String s = scanner.nextLine();
            if (s.equals("exit")) {
                break;
            }
            String[] parts = s.split(" ");
            if(parts.length != 3){
                System.out.println("Wrong number of arguments! Retry!");
                continue;
            }
            String productName = parts[0];
            int productCost;
            int productCount;
            try {
                productCost = Integer.parseInt(parts[1]);
                productCount = Integer.parseInt(parts[2]);
            } catch (NumberFormatException ex){
                System.out.println(ex.getMessage());
                System.out.println("Retry!");
                continue;
            }

            boolean productAlreadyExists = false;
            for (int i = 0; i < size; i++) {
                if (productName.equals(masOfProducts[i])) {
                    masOfCosts[i] = productCost;
                    masOfCounts[i] += productCount;
                    productAlreadyExists = true;
                }
            }

            if (!productAlreadyExists) {
                for (int i = 0; i < size; i++) {
                    if (masOfProducts[i] == null) {
                        masOfProducts[i] = productName;
                        masOfCosts[i] = productCost;
                        masOfCounts[i] = productCount;
                        break;
                    }
                }
            }
            count++;
        }



        String[] sortedProducts = new String[5];
        System.arraycopy(masOfProducts, 0, sortedProducts, 0, 5);
        Arrays.sort(sortedProducts, (o1, o2) -> {
            int res = String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
            if (res == 0) {
                res = o1.compareTo(o2);
            }
            return res;
        });
        System.out.println(Arrays.toString(sortedProducts));
        long sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += (long) masOfCosts[i] * masOfCounts[i];
        }
        System.out.println(sum);

        for (int j = 0; j < 3; j++) {
            int indexOfMostPopularProduct = 0;
            for (int i = 0; i < 5; i++) {
                if(masOfCounts[i] > masOfCounts[indexOfMostPopularProduct]){
                    indexOfMostPopularProduct = i;
                }
            }
            System.out.println("Most popular product is " + masOfProducts[indexOfMostPopularProduct]);
            masOfProducts[indexOfMostPopularProduct] = null;
            masOfCounts[indexOfMostPopularProduct] = 0;
            masOfCosts[indexOfMostPopularProduct] = 0;
        }
        System.out.println(Arrays.toString(masOfProducts));

    }
}
