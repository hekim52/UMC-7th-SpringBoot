package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    boolean ReviewRestaurantExistValidate(Long restaurantId);

    Review review(Long restaurantId, ReviewRequestDTO.ReviewDto request);
}
