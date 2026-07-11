package in.mtk.cartify.mapper;

import in.mtk.cartify.dto.CartResponse;
import in.mtk.cartify.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = CartItemMapper.class)
public interface CartMapper {

    @Mapping(target = "totalPrice", ignore = true)
    @Mapping(target = "totalItems", ignore = true)
    CartResponse toResponse(Cart cart);
}
