package in.mtk.cartify.controller;

import in.mtk.cartify.dto.ProductRequest;
import in.mtk.cartify.dto.ProductResponse;
import in.mtk.cartify.model.Product;
import in.mtk.cartify.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    @CrossOrigin
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable long id){
        ProductResponse productResponse = productService.getById(id);
        return ResponseEntity.ok(productResponse);
    }

    @PostMapping()
    public ResponseEntity<String> addProduct(@RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(productService.addProduct(productRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody ProductRequest productRequest,@PathVariable long id){
        return ResponseEntity.ok(productService.updateProduct(productRequest,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable long id){
        return ResponseEntity.ok(productService.deleteById(id));
    }
}
