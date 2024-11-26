package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ChallengingMission;

import java.util.Map;

public class RestaurantRequestDTO {

    @Getter
    public static class ReviewDto {

        @NotNull
        Long memberId;

        @NotNull
        Float star;
        @NotBlank
        String content;
    }


    @Getter
    public static class ChallengeDTO {

        @NotNull
        Long memberId;

        @ChallengingMission
        Map<String, Long> missionMemberIdMap;
    }
}
