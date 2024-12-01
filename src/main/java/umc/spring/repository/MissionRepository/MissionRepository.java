package umc.spring.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findAllByRestaurant(Restaurant restaurant, Pageable pageable);
}
