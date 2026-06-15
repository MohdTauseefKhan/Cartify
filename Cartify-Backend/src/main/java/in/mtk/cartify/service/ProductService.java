package in.mtk.cartify.service;

import in.mtk.cartify.dto.ProductRequest;
import in.mtk.cartify.dto.ProductResponse;
import in.mtk.cartify.mapper.ProductMapper;
import in.mtk.cartify.model.Product;
import in.mtk.cartify.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public ProductService(ProductRepo productRepo, ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepo.findAll();

        return productMapper.toProductResponseList(products);
    }

    public ProductResponse getById(long id){
        Product product = productRepo.findById(id).orElseThrow();
        return productMapper.toProductResponse(product);
    }

    public String addProduct(ProductRequest productRequest){
        Product product = productMapper.toProduct(productRequest);
        productRepo.save(product);
        return "PRODUCT ADDED";
    }

    public String updateProduct(ProductRequest productRequest,long id){
        Product product = productRepo.findById(id).orElseThrow();
        productMapper.updateProductFromProductRequest(productRequest,product);
        productRepo.save(product);
        return "PRODUCT UPDATED";
    }

    public String deleteById(long id) {
        Product product = productRepo.findById(id).orElseThrow();
        productRepo.delete(product);
        return "PRODUCT DELETED";
    }
}
