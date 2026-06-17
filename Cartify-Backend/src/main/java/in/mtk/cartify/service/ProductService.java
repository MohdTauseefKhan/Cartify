package in.mtk.cartify.service;

import in.mtk.cartify.dto.ProductRequest;
import in.mtk.cartify.dto.ProductResponse;
import in.mtk.cartify.dto.ProductUpdateRequest;
import in.mtk.cartify.dto.SearchRequest;
import in.mtk.cartify.exception.ResourceNotFoundException;
import in.mtk.cartify.mapper.ProductMapper;
import in.mtk.cartify.model.Product;
import in.mtk.cartify.repository.ProductRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;

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
    

    public List<String> getAllCategories() {
        return productRepo.findAllCategories();
    }

    public List<ProductResponse> searchProducts(SearchRequest searchRequest) {
        String keyword = searchRequest.keyword();
        String category = searchRequest.category();
        int page = searchRequest.page()==null?0:searchRequest.page();
        int minPrice = searchRequest.minPrice()==null?0:searchRequest.minPrice();
        int maxPrice = searchRequest.maxPrice()==null?Integer.MAX_VALUE:searchRequest.maxPrice();
        String sortDir = searchRequest.sortDir() == null || searchRequest.sortDir().equalsIgnoreCase("asc")?"asc":"desc";

        Sort sort = sortDir.equalsIgnoreCase("asc")
                ?Sort.by("price").ascending():
                Sort.by("price").descending();

        Pageable pageable = PageRequest.of(page-1,2,sort);
        List<Product> products = productRepo.searchProducts(keyword,category,minPrice,maxPrice,pageable).getContent();

        return productMapper.toProductResponseList(products);
    }
}
