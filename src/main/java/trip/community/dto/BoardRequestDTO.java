package trip.community.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import trip.community.mapper.BoardMapper;
import trip.community.model.Board;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class BoardRequestDTO {

    private BoardRequestDTO() {
        throw new IllegalStateException("Dto group class");
    }

    @Getter
    @Builder
    @Setter
    public static class boardReq {
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
}
