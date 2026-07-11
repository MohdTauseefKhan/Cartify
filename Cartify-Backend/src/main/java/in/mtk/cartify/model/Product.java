package in.mtk.cartify.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "product")
    private List<CartItem> items;

    private String name;
    private String category;
    private String subCategory;
    private Integer price;
    private Integer oldPrice;
    private String badge;
}
