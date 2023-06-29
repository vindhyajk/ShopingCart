import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double unitPrice;
    private double gst;
    private int quantity;

    public Product(String name, double unitPrice, double gst, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.gst = gst;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getGST() {
        return gst;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return unitPrice * quantity;
    }

    public double getDiscountedPrice() {
        if (unitPrice >= 500) {
            return getTotalPrice() * 0.95; // 5% discount
        } else {
            return getTotalPrice();
        }
    }

    public double getTotalGST() {
        return getTotalPrice() * (gst / 100);
    }
}

public class ShopingCart {
    public static void main(String[] args) {
        List<Product> basket = new ArrayList<>();

        // Add products to the basket
        basket.add(new Product("Leather wallet", 1100, 18, 1));
        basket.add(new Product("Umbrella", 900, 12, 4));
        basket.add(new Product("Cigarette", 200, 28, 3));
        basket.add(new Product("Honey", 100, 0, 2));

        // Find the product with the maximum GST amount
        Product maxGSTProduct = null;
        double maxGSTAmount = 0;

        for (Product product : basket) {
            double gstAmount = product.getTotalPrice() * (product.getGST() / 100);
            if (gstAmount > maxGSTAmount) {
                maxGSTAmount = gstAmount;
                maxGSTProduct = product;
            }
        }

        if (maxGSTProduct != null) {
            System.out.println("Product with maximum GST amount: " + maxGSTProduct.getName());
            System.out.println("GST Amount: Rs. " + maxGSTAmount);
        }

        // Calculate the total amount to be paid to the shopkeeper
        double totalAmount = 0;

        for (Product product : basket) {
            totalAmount += product.getDiscountedPrice();
        }

        System.out.println("Total amount to be paid to the shopkeeper: Rs. " + totalAmount);
    }
}
