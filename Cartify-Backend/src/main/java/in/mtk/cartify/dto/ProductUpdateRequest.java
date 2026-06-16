package in.mtk.cartify.dto;

import lombok.Data;

@Data
public class ProductUpdateRequest {
    private String name;
    private String category;
    private String subCategory;
    private Integer price;
    private Integer oldPrice;
    private String badge;
}
