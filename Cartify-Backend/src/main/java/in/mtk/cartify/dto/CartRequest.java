package in.mtk.cartify.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CartRequest{

        @NotNull(message = "product id cannot be blank")
        long productId;
        int quantity;

}
