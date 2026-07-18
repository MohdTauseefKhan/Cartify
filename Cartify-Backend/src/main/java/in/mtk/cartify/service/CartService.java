package in.mtk.cartify.service;

import in.mtk.cartify.dto.CartRequest;
import in.mtk.cartify.dto.CartResponse;
import in.mtk.cartify.exception.ResourceNotFoundException;
import in.mtk.cartify.mapper.CartMapper;
import in.mtk.cartify.model.Cart;
import in.mtk.cartify.model.CartItem;
import in.mtk.cartify.model.Product;
import in.mtk.cartify.repository.CartItemRepo;
import in.mtk.cartify.repository.CartRepo;
import in.mtk.cartify.repository.ProductRepo;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    private final CartRepo cartRepo;
    private final ProductRepo productRepo;
    private final CartItemRepo cartItemRepo;
    private final CartMapper cartMapper;

    public CartService(CartRepo cartRepo, ProductRepo productRepo, CartItemRepo cartItemRepo, CartMapper cartMapper) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
        this.cartItemRepo = cartItemRepo;
        this.cartMapper = cartMapper;
    }


    public String addToCart(CartRequest cartRequest) {

        Product product = productRepo.findById(cartRequest.getProductId()).orElseThrow(()-> new ResourceNotFoundException("Product not found with id: "+cartRequest.getProductId()));

        //add -> find cart if exist use that otherwise create new & user features remains
        Cart cart = cartRepo.findById(1L).orElseGet(()->{
            Cart cart1 = new Cart();
            return cartRepo.save(cart1);
        }
        );

        Optional<CartItem> cartItem = cartItemRepo.findByCartAndProduct(cart,product);

        if(cartItem.isPresent()){
            CartItem cartItem1 = cartItem.get();
            cartItem1.setQuantity(cartItem1.getQuantity()+cartRequest.getQuantity());
            cartItem1.setCart(cart);
            cartItemRepo.save(cartItem1);
        }else {
            CartItem cartItem1 = new CartItem();
            cartItem1.setProduct(product);
            cartItem1.setQuantity(cartRequest.getQuantity());
            cartItem1.setCart(cart);
            cartItemRepo.save(cartItem1);
        }

        return "Product Added To Cart";
    }

    public CartResponse getCart(long cartId) {
        Cart cart = cartRepo.findById(cartId).orElseThrow(()-> new ResourceNotFoundException("Cart Not Found With Id: "+cartId));

        CartResponse cartResponse = cartMapper.toResponse(cart);
        int totalPrice = cart.getItems()
                .stream()
                .mapToInt(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();

        int totalItems = cart.getItems()
                .stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
        cartResponse.setTotalItems(totalItems);
        cartResponse.setTotalPrice(totalPrice);

        return cartResponse;
    }

    public Void removeCart(long l) {
        Cart cart = cartRepo.findById(l).orElseThrow(()->new ResourceNotFoundException("Cart Not Found With Id: "+l));
        cartRepo.delete(cart);
        return null;
    }

    public Void increaseQuantity(long productId) {
        Cart cart = cartRepo.findById(1L).orElseThrow(()->new ResourceNotFoundException("Cart Not Found With Id: 1"));
        Product product = productRepo.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product Not Found With Id: "+productId));

        CartItem cartItem = cartItemRepo.findByCartAndProduct(cart,product).orElseThrow(()->new ResourceNotFoundException("Cart Item Not Found"));

        cartItem.setQuantity(cartItem.getQuantity()+1);
        cartItemRepo.save(cartItem);
        return null;
    }

    public Void decreaseQuantity(long productId) throws BadRequestException {
        Cart cart = cartRepo.findById(1L).orElseThrow(()->new ResourceNotFoundException("Cart Not Found With Id: 1"));
        Product product = productRepo.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product Not Found With Id: "+productId));

        CartItem cartItem = cartItemRepo.findByCartAndProduct(cart,product).orElseThrow(()->new ResourceNotFoundException("Cart Item Not Found"));

        if(cartItem.getQuantity()==0){
            throw new BadRequestException("Cannot Decrease Quantity");
        }

        cartItem.setQuantity(cartItem.getQuantity()-1);
        cartItemRepo.save(cartItem);

        if(cartItem.getQuantity()==0){
            cart.getItems().remove(cartItem);
            cartItemRepo.delete(cartItem);
            cartRepo.save(cart);
        }

        return null;
    }
}
