package trip.community.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trip.community.mapper.BoardMapper;
import trip.community.model.Board;

import java.time.LocalDateTime;

public class BoardReviewDTO {

    private BoardReviewDTO() {
        throw new IllegalStateException("Dto group class");
    }

    @Getter
    @Builder
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class createClientReq {
        private String title;
        private String content;
        private String region;

        private List<String> imageUrl;

        //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        //private LocalDateTime startTime;
        private String startTime;
        //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        //private LocalDateTime endTime;
        private String endTime;

        public Board toBoardEntity(){
            return BoardMapper.INSTANCE.toBoardEntity(this);
        }
    }


    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class clientRes {
        private Long boardId;
        private String title;
        private String content;
        private String region;
        private Long views;
        private Long likeCnt;


        private List<String> imageUrl;

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        private LocalDateTime createdAt;

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        private LocalDateTime updatedAt;

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        private LocalDateTime startTime;

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        private LocalDateTime endTime;
    }

    public static LocalDateTime timeFormatter(String inputTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(inputTime, formatter);
    }
}
