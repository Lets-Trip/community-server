package trip.community.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trip.community.dto.BoardRequestDTO;
import trip.community.dto.BoardResponseDTO;
import trip.community.mapper.BoardMapper;
import trip.community.model.Board;
import trip.community.repository.BoardRepository;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public BoardResponseDTO findBoard(Long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("Can't not find board"));
        BoardResponseDTO resDTO = BoardMapper.INSTANCE.toBoardResponseDTO(board);
        return resDTO;
    }
    @Transactional
    public BoardResponseDTO create(BoardRequestDTO req){
        Board board = req.toBoardEntity();
        Board res = boardRepository.save(board);
        BoardResponseDTO resDTO = BoardMapper.INSTANCE.toBoardResponseDTO(res);
        return resDTO;
    }

}
