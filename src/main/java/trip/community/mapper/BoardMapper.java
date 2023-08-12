package trip.community.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trip.community.dto.BoardRequestDTO;
import trip.community.dto.BoardResponseDTO;
import trip.community.model.Board;

import java.time.LocalDateTime;

@Mapper
public interface BoardMapper {
    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    @Mapping(target="startTime", source="startTime")
    @Mapping(target="endTime", source="endTime")
    Board toBoardEntity(BoardRequestDTO.boardReq req, LocalDateTime startTime, LocalDateTime endTime);

    BoardResponseDTO toBoardResponseDTO(Board board);




}
