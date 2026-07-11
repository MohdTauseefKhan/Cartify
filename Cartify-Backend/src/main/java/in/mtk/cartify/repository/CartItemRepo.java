package in.mtk.cartify.repository;

import in.mtk.cartify.model.Cart;
import in.mtk.cartify.model.CartItem;
import in.mtk.cartify.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem,Long> {

    Optional<CartItem> findByCartAndProduct(Cart cart, Product product);
}
