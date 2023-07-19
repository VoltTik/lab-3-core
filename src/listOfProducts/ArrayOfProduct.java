package listOfProducts;

import java.util.Arrays;


public class ArrayOfProduct {

    private Product[] products;
    private int numberOfElements;


    public ArrayOfProduct() {
        this.products = new Product[5];
        this.numberOfElements = 0;
    }

    @Override
    public String toString() {
        String[] p = new String[this.products.length];
        for (int i = 0; i < numberOfElements; i ++) {
            p[i] = this.products[i].getProductName();
        }
        return Arrays.toString(p);

    }

    public void productAvailabilityCheck (Product product) {
        boolean productAlreadyExists = false;
        for (int i = 0; i < numberOfElements; i++) {
            if (product.getProductName().equals(products[i].getProductName())) {
                products[i] = new Product(product.getProductName(), product.getProductCost(), products[i].getProductCount() + product.getProductCount());
                productAlreadyExists = true;
                break;
            }
        }
        if (!productAlreadyExists) {
            if (numberOfElements < 5) {
                products[numberOfElements] = new Product(product.getProductName(), product.getProductCost(),product.getProductCount());
                numberOfElements ++;
            }
        }
    }

    public long calculateProductsSum () {
        long sum = 0;
        for (int i = 0; i < numberOfElements; i++) {
            sum += (long) products[i].getProductCost() * products[i].getProductCount();
        }
        return sum;
    }

    public String[] productSort () {
        String[] sortedProductsName = new String[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            sortedProductsName[i] = products[i].getProductName();
        }
        Arrays.sort(sortedProductsName, (o1, o2) -> {
            int res = String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
            if (res == 0) {
                res = o1.compareTo(o2);
            }
            return res;
        });
        return sortedProductsName;
    }

    public void getStatistics (){
        for (int j = 0; j < 3; j++) {
            int indexOfMostPopularProduct = 0;
            for (int i = 0; i < numberOfElements; i++) {
                if(products[i].getProductCost() > products[indexOfMostPopularProduct].getProductCost()){
                    indexOfMostPopularProduct = i;
                }
            }
            System.out.println("Most popular product is " + products[indexOfMostPopularProduct].getProductName());
            products[indexOfMostPopularProduct].setProductName(null);
            products[indexOfMostPopularProduct].setProductCost(0);
            products[indexOfMostPopularProduct].setProductCount(0);
        }
    }
}
