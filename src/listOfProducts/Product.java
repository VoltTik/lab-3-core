package listOfProducts;

public class Product {

     private String productName;
    private int productCost;
    private int productCount;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCost() {
        return productCost;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Product(String productName, int productCost, int productCount) {
        this.productName = productName;
        this.productCost = productCost;
        this.productCount = productCount;
    }

    public Product() {
    }
}
