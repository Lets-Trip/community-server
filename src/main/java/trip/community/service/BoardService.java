package trip.community.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trip.community.dto.BoardRequestDTO;
import trip.community.dto.BoardResponseDTO;
import trip.community.mapper.BoardMapper;
import trip.community.model.Board;
import trip.community.repository.BoardRepository;

import java.util.Comparator;
import java.util.List;

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
    @Transactional(readOnly = true)
    public List<BoardResponseDTO> findBoardList(){
        List<Board> board =  boardRepository.findAllByOrderByCreatedAtAsc();
        List<BoardResponseDTO> resDTO = board.stream().map(BoardMapper.INSTANCE::toBoardResponseDTO).toList();
        return resDTO;
    }

    @Transactional
    public BoardResponseDTO create(BoardRequestDTO req){
        Board board = req.toBoardEntity();
        Board res = boardRepository.save(board);
        BoardResponseDTO resDTO = BoardMapper.INSTANCE.toBoardResponseDTO(res);
        return resDTO;
    }

    @Transactional
    public BoardResponseDTO update(Long boardId,BoardRequestDTO req){
        //Board board = req.toBoardEntity();
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("board Not Found"));
        board.setBoard(req.getTitle(), req.getContent(), req.getRegion(), req.getImageUrl());
        BoardResponseDTO resDTO = BoardMapper.INSTANCE.toBoardResponseDTO(board);
        return resDTO;
    }
}
