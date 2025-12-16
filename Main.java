package onlineShoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cart cart = new Cart();
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(50000, "Laptop", 1L, 5000));
        products.add(new Electronics(20000, "Mobile", 2L, 2000));

        int choice;

        do {
            System.out.println("\n===== ONLINE SHOPPING CART =====");
            System.out.println("1. View Products");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Update Quantity");
            System.out.println("5. View Cart");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Products:");
                    for (Product p : products) {
                        System.out.println(
                                "ID: " + p.getProductId() +
                                " | Name: " + p.getProductName() +
                                " | Price: " + p.getProductPrice()
                        );
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    Long addId = sc.nextLong();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    Product addProduct = findProductById(products, addId);

                    if (addProduct != null) {
                        cart.addItem(addProduct, quantity);
                        System.out.println("Product added to cart");
                    } else {
                        System.out.println("Invalid Product ID");
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID to remove: ");
                    Long removeId = sc.nextLong();
                    cart.removeItem(removeId);
                    System.out.println("Product removed (if it existed)");
                    break;

                case 4:
                    System.out.print("Enter Product ID: ");
                    Long updateId = sc.nextLong();

                    System.out.print("Enter New Quantity: ");
                    int updateQuantity = sc.nextInt();

                    Product updateProduct = findProductById(products, updateId);

                    if (updateProduct != null) {
                        cart.updateQuantity(updateProduct, updateQuantity);
                        System.out.println("Quantity updated");
                    } else {
                        System.out.println("Invalid Product ID");
                    }
                    break;

                case 5:
                    cart.displayCart();
                    break;

                case 6:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }

    private static Product findProductById(List<Product> products, Long productId) {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                return p;
            }
        }
        return null;
    }
}
