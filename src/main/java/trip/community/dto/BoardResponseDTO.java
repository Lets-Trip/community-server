package trip.community.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardResponseDTO {
    private String title;
    private String content;
    private String region;

    private String imageUrl;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
