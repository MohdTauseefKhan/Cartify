package in.mtk.cartify.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String category;
    private String subCategory;
    private int price;
    private int oldPrice;
    private String badge;
}
