package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDto {

        @NotNull
        Long memberId;

        @NotNull
        Float star;
        @NotBlank
        String content;
    }
}
