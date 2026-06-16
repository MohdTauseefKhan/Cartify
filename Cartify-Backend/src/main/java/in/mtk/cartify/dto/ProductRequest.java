package in.mtk.cartify.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NonNull;

@Data
public class ProductRequest {

    @NotBlank(message = "Product name cannot be blank or whitespace")
    private String name;

    @NotNull(message = "Product category cannot be blank")
    private String category;

    @NotNull(message = "Product sub-category cannot be blank")
    private String subCategory;

    @NotNull(message = "Product price cannot be blank")
    @PositiveOrZero(message = "Product price cannot be negative")
    private Integer price;

    @Positive(message = "Product old price cannot be negative")
    @NotNull(message = "Product old price cannot be blank")
    private Integer oldPrice;

    private String badge;
}
