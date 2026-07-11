package in.mtk.cartify.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartResponse{

        long id;
        List<CartItemResponse> items;
        int totalPrice;
        int totalItems;
}
