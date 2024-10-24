/**
 * @author djlar
 */
package music.data;
import java.io.*;
import java.util.*;
import music.business.Product;

public class ProductIO {

    private static String filePath = "../WEB-INF/products.txt"; // Path to the product file
    private static List<Product> products = new ArrayList<>(); // Initialize the products list

    // Initialize the file path for reading and writing
    public static void init(String path) {
        filePath = path;
        selectProducts(); // Load products from the file into the list on initialization
    }

    // Selects all products from the products.txt file
    public static List<Product> selectProducts() {
        products.clear(); // Clear the list to avoid duplicates
        File file = new File(filePath);
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 3) {
                    Product p = new Product();
                    p.setCode(data[0]);
                    p.setDescription(data[1]);
                    p.setPrice(Double.parseDouble(data[2]));
                    products.add(p);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading products file: " + e.getMessage());
        }
        return products; // Return the list of products
    }

    // Select a product by its code
    public static Product selectProductByCode(String productCode) {
    for (Product product : products) {
        if (product.getCode().equals(productCode)) {
            return product; // Return the product if found
        }
    }
    return null; // Return null if the product is not found
}
    public static void addOrUpdateProduct(Product product) {
        // Check if the product already exists
        boolean found = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCode().equals(product.getCode())) {
                products.set(i, product); // Update existing product
                found = true;
                break;
            }
        }
        if (!found) {
            products.add(product); // Add new product
        }
        writeProductsToFile(); // Save changes to the file
    }

    // Delete a product by its code
    public static void deleteProductByCode(String productCode) {
        products.removeIf(product -> product.getCode().equals(productCode)); // Remove the product from the list
        writeProductsToFile(); // Write the updated product list back to the file
    }

    // Write the current product list to the file
    private static void writeProductsToFile() {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath))) {
            for (Product product : products) {
                out.println(product.getCode() + "|" + product.getDescription() + "|" + product.getPrice());
            }
        } catch (IOException e) {
            System.out.println("Error writing to products file: " + e.getMessage());
        }
    }
}
