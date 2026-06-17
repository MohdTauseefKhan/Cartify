package in.mtk.cartify.dto;

import org.springframework.web.bind.annotation.RequestParam;

public record SearchRequest(
        String keyword,
        Integer page,
        Integer minPrice,
        Integer maxPrice,
        String category,
        String sortDir
) {
}
