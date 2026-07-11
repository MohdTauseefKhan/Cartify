package in.mtk.cartify.controller;

import in.mtk.cartify.dto.CartRequest;
import in.mtk.cartify.dto.CartResponse;
import in.mtk.cartify.service.CartService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @PostMapping()
    public ResponseEntity<String> addToCart(@Valid @RequestBody CartRequest cartRequest){
        return ResponseEntity.ok(cartService.addToCart(cartRequest));
    }

    @GetMapping()
    public ResponseEntity<CartResponse> getCart(){
        return ResponseEntity.ok(cartService.getCart(1L));
    }

    @DeleteMapping
    public ResponseEntity<Void> removeCart(){
        return ResponseEntity.status(HttpStatusCode.valueOf(204)).body(cartService.removeCart(1L));
    }

    @PutMapping("/increase/{productId}")
    public ResponseEntity<Void> increaseQuantity(@RequestBody int quantity,@PathVariable long productId){
        return ResponseEntity.ok(cartService.increaseQuantity(quantity,productId));
    }
}
