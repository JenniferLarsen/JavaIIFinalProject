/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package music.data;

/**
 *
 * @author 1elli
 *
 * Modifications:
 * - Replaced JDBC code with JPA operations for database interactions.
 * - Added an EntityManagerFactory to manage entity managers.
 * - Replaced connection handling with JPA EntityManager and EntityTransaction.
 * - Removed old JDBC connection pool and connection management code.
 * - Used JPA queries and methods to add, update, and delete products.
 */

import javax.persistence.*;
import java.util.List;
import music.business.Product;

public class ProductDB {

    // Create an EntityManagerFactory to handle EntityManager instances
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProductPU");
    
    // Method to get all products from the database using JPA
    public static List<Product> getAllProducts() {
        EntityManager em = emf.createEntityManager();
        List<Product> products = null;
        try {
            // Use JPA to execute a query and retrieve products
            products = em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        } finally {
            // Ensure the EntityManager is closed after use
            em.close();
        }
        return products;
    }

    // Method to add a product to the database using JPA
    public static void addProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin(); // Begin transaction
            em.persist(product); // Persist the product entity
            trans.commit(); // Commit transaction
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback(); // Roll back if an error occurs
            }
            e.printStackTrace();
        } finally {
            em.close(); // Close EntityManager
        }
    }

    // Method to update an existing product in the database using JPA
    public static void updateProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin(); // Begin transaction
            em.merge(product); // Merge the product entity to update it
            trans.commit(); // Commit transaction
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback(); // Roll back if an error occurs
            }
            e.printStackTrace();
        } finally {
            em.close(); // Close EntityManager
        }
    }

    // Method to delete a product from the database by product code using JPA
    public static void deleteProduct(String productCode) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin(); // Begin transaction
            Product product = em.find(Product.class, productCode); // Find the product by code
            if (product != null) {
                em.remove(product); // Remove the product entity if found
            }
            trans.commit(); // Commit transaction
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback(); // Roll back if an error occurs
            }
            e.printStackTrace();
        } finally {
            em.close(); // Close EntityManager
        }
    }
}
