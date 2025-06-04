package mandya.two.commerce_app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Laptop {
    @Id
    private String model;
    private int ram;
    private int ssd;
    private String processor;
    private int quantity;
    private double cost;
}
