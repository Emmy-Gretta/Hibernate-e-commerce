package rca.ac.rw.mis.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id") // Correct placement for specifying the column name in the foreign key relation
    private User user;

    @ManyToMany
    @JoinTable(
            name = "order_products", // Name of the join table.
            joinColumns = @JoinColumn(name = "order_id"), // Order's side of the relationship
            inverseJoinColumns = @JoinColumn(name = "product_id") // Product's side of the relationship
    )
    private List<Product> products = new ArrayList<>();
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime orderDate;

    public Orders() {
    }

    public Orders(User user, List<Product> products, LocalDateTime orderDate) {
        this.user = user;
        this.products = products;
        this.orderDate = orderDate;
    }

    // Standard getters and setters omitted for brevity

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
