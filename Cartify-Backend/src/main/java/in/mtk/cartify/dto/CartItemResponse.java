package in.mtk.cartify.dto;

import lombok.Data;

@Data
public class CartItemResponse{

        long id;
        String name;
        int price;
        int oldPrice;
        int productId;
        int quantity;
        int totalPrice;

}
