package trip.community.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trip.community.dto.BoardReviewDTO;
import trip.community.dto.BoardReviewDTO.clientRes;
import trip.community.model.Board;

import java.time.LocalDateTime;

@Mapper
public interface BoardMapper {
    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    @Mapping(target="startTime", source="startTime")
    @Mapping(target="endTime", source="endTime")
    Board toBoardEntity(BoardReviewDTO.createClientReq req, LocalDateTime startTime, LocalDateTime endTime);

    clientRes toBoardResponseDTO(Board board);




}
