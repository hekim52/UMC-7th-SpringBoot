package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ChallengingMission;

import java.time.LocalDate;
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

    @Getter
    public static class AddMissionDTO {

        @NotNull
        Long memberId;

        @NotNull
        Long moreThanPrice;
        @NotNull
        Long getPoint;
        @NotNull
        LocalDate d_day;
        @NotNull
        Long ownerId;
    }
}
