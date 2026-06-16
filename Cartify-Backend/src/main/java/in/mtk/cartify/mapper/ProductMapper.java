package in.mtk.cartify.mapper;

import in.mtk.cartify.dto.ProductRequest;
import in.mtk.cartify.dto.ProductResponse;
import in.mtk.cartify.dto.ProductUpdateRequest;
import in.mtk.cartify.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy =
        NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    List<ProductResponse> toProductResponseList(List<Product> products);
    ProductResponse toProductResponse(Product product);
    Product toProduct(ProductRequest productRequest);
    ProductRequest toProductRequest(Product product);

    void updateProductFromProductRequest(ProductRequest productRequest, @MappingTarget Product product);
    void updateProductFromProductUpdateRequest(ProductUpdateRequest productUpdateRequest,@MappingTarget Product product);
}
