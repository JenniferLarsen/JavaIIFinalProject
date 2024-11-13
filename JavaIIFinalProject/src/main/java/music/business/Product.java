/**
 *
 * @author djlar
 * 
 * Ellis modification 11-12-24
 * Added @Entity to designate the class as a JPA entity.
 * Used @Table to specify the corresponding database table.
 * Added @Id to code to indicate it as the primary key.
 * Used @Column annotations on all fields to map them to database 
 * columns and specify their properties.
 */

package music.business;

import jakarta.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity // Marks this class as a JPA entity
@Table(name = "product") // Specifies the table name in the database
public class Product implements Serializable {
    
    @Id // Marks this field as the primary key
    @Column(name = "code", nullable = false, unique = true) // Maps to the 'code' column in the database
    private String code;

    @Column(name = "description", nullable = false) // Maps to the 'description' column
    private String description;

    @Column(name = "price", nullable = false) // Maps to the 'price' column
    private double price;

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPriceFormatted() {
        return String.format("%.2f", price);
    }
}
