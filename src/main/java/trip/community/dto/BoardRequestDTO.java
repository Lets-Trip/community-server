package trip.community.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import trip.community.mapper.BoardMapper;
import trip.community.model.Board;

import java.time.ZonedDateTime;

@Getter
@Builder
@Setter
public class BoardRequestDTO {

    private String title;
    private String content;
    private String region;

    private String imageUrl;
//
//    private ZonedDateTime startTime;
//    private ZonedDateTime endTime;

    public Board toBoardEntity(){
        return BoardMapper.INSTANCE.toBoardEntity(this);
    }
}
