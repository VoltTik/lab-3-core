package listOfProducts;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Product product = new Product();
        ArrayOfProduct arrayOfProduct = new ArrayOfProduct();
        Scanner scanner = new Scanner(System.in);


        int count = 0;
        while (scanner.hasNext() && count < 5) {
            String s = scanner.nextLine();
            if (s.equals("q")) {
                break;
            }
            String[] parts = s.split(" ");
            if(parts.length != 3){
                System.out.println("Wrong number of arguments! Retry!");
                continue;
            }
            product.setProductName(parts[0]);
            try {
                product.setProductCost(Integer.parseInt(parts[1]));
                product.setProductCount(Integer.parseInt(parts[2]));
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Retry!");
                continue;
            }
            arrayOfProduct.productAvailabilityCheck(product);
            count++;
        }
        String[] sortedProducts = arrayOfProduct.productSort();
        long sum = arrayOfProduct.calculateProductsSum();
        System.out.println("Отсортированный список покупок: " + Arrays.toString(sortedProducts));
        System.out.println("Сумма всех продуктов: " + sum);
        arrayOfProduct.getStatistics();
        System.out.println("Список покупок после удаления: " + arrayOfProduct);

    }
}
