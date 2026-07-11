package in.mtk.cartify.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn
    private Cart cart;

    @ManyToOne
    @JoinColumn
    private Product product;

    private int quantity;
}
