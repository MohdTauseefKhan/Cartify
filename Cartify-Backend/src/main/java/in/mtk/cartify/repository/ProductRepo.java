package in.mtk.cartify.repository;

import in.mtk.cartify.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("""
    SELECT p
    FROM Product p
    WHERE UPPER(p.name) LIKE UPPER(CONCAT('%', :keyword, '%'))
       OR UPPER(p.subCategory) LIKE UPPER(CONCAT('%', :keyword, '%'))
""")
    List<Product> findProductsByKeyword(@Param("keyword") String keyword);

    List<Product> findAllByCategory(String category);
}
