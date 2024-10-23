/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package music.data;

/**
 *
 * @author djlar
 */

import java.io.*;
import java.util.*;
import music.business.Product;

public class ProductIO {

    private static String filePath = "/WEB-INF/products.txt";
    private static List<Product> products = null;

    public static void init(String path) {
        filePath = path;
    }

    public static List<Product> selectProducts() {
        products = new ArrayList<>();
        File file = new File(filePath);
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line = in.readLine();
            while (line != null) {
                String[] data = line.split("\\|");
                if (data.length == 3) {
                    Product p = new Product();
                    p.setCode(data[0]);
                    p.setDescription(data[1]);
                    p.setPrice(Double.parseDouble(data[2]));
                    products.add(p);
                }
                line = in.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return products;
    }
}
