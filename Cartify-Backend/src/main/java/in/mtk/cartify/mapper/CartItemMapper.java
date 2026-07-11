package in.mtk.cartify.mapper;

import in.mtk.cartify.dto.CartItemResponse;
import in.mtk.cartify.dto.CartResponse;
import in.mtk.cartify.model.Cart;
import in.mtk.cartify.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartItemMapper {


    @Mapping(source = "product.name",target = "name")
    @Mapping(source = "product.price",target = "price")
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.oldPrice",target = "oldPrice")
    @Mapping(target = "totalPrice",expression = "java(cartItem.getProduct().getPrice()*cartItem.getQuantity())")
    CartItemResponse toResponse(CartItem cartItem);
}
