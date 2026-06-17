package in.mtk.cartify.service;

import in.mtk.cartify.dto.ProductRequest;
import in.mtk.cartify.dto.ProductResponse;
import in.mtk.cartify.dto.ProductUpdateRequest;
import in.mtk.cartify.exception.ResourceNotFoundException;
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
        Product product = productRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Product not found with id: "+id));

        return productMapper.toProductResponse(product);
    }

    public String addProduct(ProductRequest productRequest){
        Product product = productMapper.toProduct(productRequest);
        productRepo.save(product);
        return "PRODUCT ADDED";
    }

    public String updateProduct(ProductRequest productRequest,long id){
        Product product = productRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Product not found with id: "+id));

        productMapper.updateProductFromProductRequest(productRequest,product);
        productRepo.save(product);

        return "PRODUCT UPDATED";
    }

    public String deleteById(long id) {
        Product product = productRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Product not found with id: "+id));

        productRepo.delete(product);
        return "PRODUCT DELETED";
    }

    public String updateProduct(ProductUpdateRequest productUpdateRequest, long id){
        Product product = productRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Product not found with id: "+id));

        productMapper.updateProductFromProductUpdateRequest(productUpdateRequest,product);
        productRepo.save(product);

        return "PRODUCT UPDATED";
    }

    public List<ProductResponse> getAllProductByCategory(String category){
        List<Product> product = productRepo.findAllByCategory(category);

        if(product.isEmpty()){
            throw new ResourceNotFoundException("Product not found with category: "+category);
        }

        return productMapper.toProductResponseList(product);
    }

    public List<ProductResponse> gettAllProductByKeyword(String keyword) {
        List<Product> products = productRepo.findProductsByKeyword(keyword);

        if (products.isEmpty()){
            throw new ResourceNotFoundException("Product not found");
        }
        return productMapper.toProductResponseList(products);
    }
}
