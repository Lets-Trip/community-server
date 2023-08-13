package trip.community.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
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
    public static class createClientReq {
        private String title;
        private String content;
        private String region;

        private String imageUrl;

        //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        //private LocalDateTime startTime;
        private String startTime;
        //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        //private LocalDateTime endTime;
        private String endTime;

//        public LocalDateTime startTimeFormat(){
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//            return LocalDateTime.parse(this.startTime, formatter);
//        }
//        public LocalDateTime endTimeFormat(){
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//            return LocalDateTime.parse(this.endTime, formatter);
//        }

        public Board toBoardEntity(LocalDateTime startTime, LocalDateTime endTime){
            return BoardMapper.INSTANCE.toBoardEntity(this, startTime, endTime);
        }
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class clientRes {
        private String title;
        private String content;
        private String region;

        private String imageUrl;

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        private LocalDateTime createdAt;

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        private LocalDateTime updatedAt;

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        private LocalDateTime startTime;

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        private LocalDateTime endTime;
    }
}
