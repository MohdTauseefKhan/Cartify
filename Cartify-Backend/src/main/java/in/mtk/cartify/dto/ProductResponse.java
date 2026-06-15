package in.mtk.cartify.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Data
public class ProductResponse {
    private Long id;

    private String name;
    private String category;
    private String subCategory;
    private int price;
    private int oldPrice;
    private String badge;
}
