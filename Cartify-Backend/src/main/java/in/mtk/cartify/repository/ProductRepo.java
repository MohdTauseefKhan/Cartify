package in.mtk.cartify.repository;

import in.mtk.cartify.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {


    List<Product> findAllByCategory(String category);

    @Query("SELECT DISTINCT p.category FROM Product p")
    List<String> findAllCategories();

    @Query("""
    SELECT p
    FROM Product p
    WHERE
        (:keyword IS NULL OR
            LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
            OR
            LOWER(p.subCategory) LIKE LOWER(CONCAT('%', :keyword, '%'))
        )
    AND
        (:category IS NULL OR p.category = :category)
    AND
        p.price BETWEEN :minPrice AND :maxPrice
""")
    Page<Product> searchProducts(
            String keyword,
            String category,
            int minPrice,
            int maxPrice,
            Pageable pageable
    );
}
