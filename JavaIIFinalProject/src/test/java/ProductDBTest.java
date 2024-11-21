/**
 *
 * @author djlar
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import music.business.Product;
import music.data.ProductDB;

public class ProductDBTest {

    private static EntityManagerFactory emf;
    private EntityManager em;

    @BeforeEach
    public void setup() {
        // Use the correct persistence unit name from persistence.xml
        emf = Persistence.createEntityManagerFactory("my_persistence_unit");  // Updated name
        em = emf.createEntityManager();
    }

    @AfterEach
    public void tearDown() {
        // Close the EntityManager after each test
        em.close();
    }

    @Test
    public void testAddProduct() {
        // Add product to DB
        Product newProduct = new Product();
        newProduct.setCode("P001");
        newProduct.setDescription("Test Product");
        newProduct.setPrice(19.99);

        ProductDB.addProduct(newProduct);

        // Fetch product by code
        Product fetchedProduct = em.find(Product.class, "P001");
        assertNotNull(fetchedProduct);
        assertEquals("Test Product", fetchedProduct.getDescription());
        assertEquals(19.99, fetchedProduct.getPrice());
    }

    @Test
    public void testUpdateProduct() {
        // Add product first
        Product productToUpdate = new Product();
        productToUpdate.setCode("P001");
        productToUpdate.setDescription("Old Product");
        productToUpdate.setPrice(10.99);
        ProductDB.addProduct(productToUpdate);

        // Update product
        productToUpdate.setDescription("Updated Product");
        productToUpdate.setPrice(15.99);
        ProductDB.updateProduct(productToUpdate);

        // Fetch updated product
        Product updatedProduct = em.find(Product.class, "P001");
        assertNotNull(updatedProduct);
        assertEquals("Updated Product", updatedProduct.getDescription());
        assertEquals(15.99, updatedProduct.getPrice());
    }

    @Test
    public void testDeleteProduct() {
        // Add product to delete
        Product productToDelete = new Product();
        productToDelete.setCode("P001");
        productToDelete.setDescription("Product to Delete");
        productToDelete.setPrice(12.99);
        ProductDB.addProduct(productToDelete);

        // Delete the product
        ProductDB.deleteProduct("P001");

        // Verify product is deleted
        Product deletedProduct = em.find(Product.class, "P001");
        assertNull(deletedProduct);
    }
}
