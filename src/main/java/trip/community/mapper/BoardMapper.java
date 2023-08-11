package trip.community.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import trip.community.dto.BoardRequestDTO;
import trip.community.dto.BoardResponseDTO;
import trip.community.model.Board;

@Mapper
public interface BoardMapper {
    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    Board toBoardEntity(BoardRequestDTO req);

    BoardResponseDTO toBoardResponseDTO(Board board);




}
